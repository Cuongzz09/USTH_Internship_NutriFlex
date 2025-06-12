package com.nutriflex.app.ui.kcal

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.nutriflex.app.databinding.FragmentKcalBeforeBinding
import com.nutriflex.app.network.KcalRequest
import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import androidx.core.app.ActivityCompat
import org.osmdroid.config.Configuration
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.MapView
import org.osmdroid.views.overlay.Polyline
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.content.Context
import org.osmdroid.views.overlay.Marker
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.tasks.CancellationTokenSource
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationResult
import com.google.android.gms.location.Priority
import android.os.Looper

class KcalBeforeFragment : Fragment() {
    private var _binding: FragmentKcalBeforeBinding? = null
    private val binding get() = _binding!!
    private val viewModel: KcalViewModel by viewModels()
    private lateinit var mapView: MapView
    private val routePoints = mutableListOf<GeoPoint>()
    private var isMeasuring = false
    private var startTime = 0L
    private var locationManager: LocationManager? = null
    private val locationListener = object : LocationListener {
        override fun onLocationChanged(location: Location) {
            if (isMeasuring) {
                val point = GeoPoint(location.latitude, location.longitude)
                routePoints.add(point)
                drawRouteOrMarker()
            }
        }
        override fun onStatusChanged(provider: String?, status: Int, extras: Bundle?) {}
        override fun onProviderEnabled(provider: String) {}
        override fun onProviderDisabled(provider: String) {}
    }
    private var lastElapsedMinutes = 0
    private var lastElapsedSeconds = 0
    private lateinit var fusedLocationClient: FusedLocationProviderClient
    private var lastKnownGeoPoint: GeoPoint? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentKcalBeforeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mapView = binding.mapView
        Configuration.getInstance().userAgentValue = requireContext().packageName
        mapView.setMultiTouchControls(true)
        mapView.controller.setZoom(18.0)
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(requireActivity())
        // Lấy vị trí thực tế khi mở fragment
        getCurrentLocation { geoPoint ->
            lastKnownGeoPoint = geoPoint
            mapView.controller.setCenter(geoPoint)
        }
        binding.btnStart.setOnClickListener {
            if (ActivityCompat.checkSelfPermission(requireContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(requireActivity(), arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), 1001)
                return@setOnClickListener
            }
            isMeasuring = true
            startTime = System.currentTimeMillis()
            routePoints.clear()
            binding.tvResult.text = "Đang đo..."
            locationManager = requireContext().getSystemService(Context.LOCATION_SERVICE) as LocationManager
            locationManager?.requestLocationUpdates(LocationManager.GPS_PROVIDER, 2000, 1f, locationListener)
            // Lấy lại vị trí thực tế khi bắt đầu đo
            getCurrentLocation { geoPoint ->
                lastKnownGeoPoint = geoPoint
                mapView.controller.setCenter(geoPoint)
            }
        }
        binding.btnStop.setOnClickListener {
            if (isMeasuring) {
                isMeasuring = false
                locationManager?.removeUpdates(locationListener)
                val elapsedMillis = System.currentTimeMillis() - startTime
                val minutes = (elapsedMillis / 60000).toInt()
                val seconds = ((elapsedMillis % 60000) / 1000).toInt()
                val duration = if (minutes == 0 && seconds > 0) 1 else minutes // Đảm bảo tối thiểu 1 phút nếu có hoạt động
                val distance = calculateDistance(routePoints)
                val routeStr = routePoints.joinToString(",") { "${it.longitude} ${it.latitude}" }
                // Nếu không di chuyển, thêm điểm hiện tại nếu chưa có
                if (routePoints.isEmpty() && ActivityCompat.checkSelfPermission(requireContext(), Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                    val lm = requireContext().getSystemService(Context.LOCATION_SERVICE) as LocationManager
                    val lastLoc = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER)
                    lastLoc?.let {
                        val point = GeoPoint(it.latitude, it.longitude)
                        routePoints.add(point)
                    }
                }
                drawRouteOrMarker()
                val testRequest = KcalRequest(
                    userId = 1,
                    distance = distance,
                    duration = duration,
                    weight = 70.0,
                    route = routeStr
                )
                viewModel.measureAndSave(testRequest)
                // Lưu lại thời gian thực tế để hiển thị phút:giây
                lastElapsedMinutes = minutes
                lastElapsedSeconds = seconds
            }
        }
        viewModel.measureResult.observe(viewLifecycleOwner) { result ->
            val distance = result?.distance ?: 0.0
            val duration = result?.duration ?: 0
            val pace = if (distance > 0 && duration > 0) {
                String.format("%.2f", (duration.toDouble() / distance))
            } else "--"
            val elevation = 0 // Chưa đo được độ cao thực tế
            val heartBeat = "--" // Chưa kết nối đồng hồ
            val timeStr = String.format("%d min %02d sec", lastElapsedMinutes, lastElapsedSeconds)
            var resultText =
                "Distance: ${String.format("%.2f", distance)} km\n" +
                "Kcal: ${result?.kcal ?: 0}\n" +
                "Pace: $pace min/km\n" +
                "Elevation: $elevation m\n" +
                "Heart beat: $heartBeat\n" +
                "Time: $timeStr"
            if (lastElapsedMinutes < 10) {
                resultText += "\nGreat start! Try to do at least 10 minutes of cardio for better health."
            }
            binding.tvResult.text = resultText
        }
    }

    private fun drawRouteOrMarker() {
        mapView.overlays.clear()
        if (routePoints.size > 1) {
            val polyline = Polyline()
            polyline.setPoints(routePoints)
            polyline.outlinePaint.color = resources.getColor(android.R.color.holo_blue_dark, null)
            polyline.outlinePaint.strokeWidth = 8f
            mapView.overlays.add(polyline)
            mapView.controller.setCenter(routePoints.last())
        } else if (routePoints.size == 1) {
            val marker = Marker(mapView)
            marker.position = routePoints[0]
            marker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM)
            marker.title = "Vị trí hiện tại"
            mapView.overlays.add(marker)
            mapView.controller.setCenter(routePoints[0])
        }
        mapView.invalidate()
    }

    private fun calculateDistance(points: List<GeoPoint>): Double {
        var dist = 0.0
        for (i in 1 until points.size) {
            dist += points[i - 1].distanceToAsDouble(points[i])
        }
        return dist / 1000.0 // m to km
    }

    private fun getCurrentLocation(onResult: (GeoPoint) -> Unit) {
        if (ActivityCompat.checkSelfPermission(requireContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            onResult(GeoPoint(21.0285, 105.8542)) // Hà Nội fallback
            return
        }
        val locationRequest = com.google.android.gms.location.LocationRequest.Builder(Priority.PRIORITY_HIGH_ACCURACY, 1000)
            .setMaxUpdates(1)
            .build()
        val locationCallback = object : LocationCallback() {
            override fun onLocationResult(result: LocationResult) {
                val location = result.lastLocation
                if (location != null) {
                    onResult(GeoPoint(location.latitude, location.longitude))
                } else {
                    onResult(GeoPoint(21.0285, 105.8542)) // fallback Hà Nội
                }
                fusedLocationClient.removeLocationUpdates(this)
            }
        }
        fusedLocationClient.requestLocationUpdates(locationRequest, locationCallback, Looper.getMainLooper())
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
} 