package com.nutriflex.app.network

import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

// Data models

data class KcalRequest(
    val userId: Long,
    val distance: Double,
    val duration: Int,
    val weight: Double,
    val route: String?
)

data class KcalRecord(
    val id: Long = 0,
    val userId: Long,
    val distance: Double,
    val duration: Int,
    val weight: Double,
    val kcal: Double,
    val route: String?,
    val createdAt: String
)

interface KcalApi {
    @POST("api/kcal/measure")
    suspend fun measureAndSave(@Body req: KcalRequest): KcalRecord

    @GET("api/kcal/history/{userId}")
    suspend fun getHistory(@Path("userId") userId: Long): List<KcalRecord>
} 