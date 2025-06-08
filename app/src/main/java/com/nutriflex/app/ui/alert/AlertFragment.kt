package com.nutriflex.app.ui.alert

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayoutMediator
import com.nutriflex.app.databinding.FragmentAlertBinding

class AlertFragment : Fragment() {
    private var _binding: FragmentAlertBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAlertBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViewPager()
    }

    private fun setupViewPager() {
        val adapter = object : FragmentStateAdapter(this) {
            override fun getItemCount() = 2
            override fun createFragment(position: Int): Fragment = when (position) {
                0 -> AlertTrainingFragment()
                1 -> AlertMealFragment()
                else -> throw IllegalArgumentException()
            }
        }
        binding.viewPagerAlert.adapter = adapter
        TabLayoutMediator(binding.tabLayoutAlert, binding.viewPagerAlert) { tab, position ->
            tab.text = when (position) {
                0 -> "Training"
                1 -> "Meal"
                else -> null
            }
        }.attach()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
} 