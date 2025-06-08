package com.nutriflex.app

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build

class NutriFlexApp : Application() {
    override fun onCreate() {
        super.onCreate()
        createNotificationChannels()
    }

    private fun createNotificationChannels() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val workoutChannel = NotificationChannel(
                CHANNEL_WORKOUT_ID,
                "Workout Reminders",
                NotificationManager.IMPORTANCE_HIGH
            ).apply {
                description = "Notifications for workout schedules"
            }

            val nutritionChannel = NotificationChannel(
                CHANNEL_NUTRITION_ID,
                "Nutrition Reminders",
                NotificationManager.IMPORTANCE_HIGH
            ).apply {
                description = "Notifications for meal schedules"
            }

            val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannels(listOf(workoutChannel, nutritionChannel))
        }
    }

    companion object {
        const val CHANNEL_WORKOUT_ID = "workout_channel"
        const val CHANNEL_NUTRITION_ID = "nutrition_channel"
    }
} 