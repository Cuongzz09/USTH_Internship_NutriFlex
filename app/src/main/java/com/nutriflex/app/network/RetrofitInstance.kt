package com.nutriflex.app.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    val api: KcalApi by lazy {
        Retrofit.Builder()
            .baseUrl("http://10.0.2.2:8080/") // Dùng 10.0.2.2 cho Android emulator
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(KcalApi::class.java)
    }
} 