package com.example.mvi_dummy.analytics_helper

import android.util.Log
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AnalyticsHelper @Inject constructor() {
    fun loginHomeScreen(screen: String,action: String) {
        Log.d("AnalyticsHelper", "Application status: $screen to $action")

    }
    fun logScreenTransition(fromScreen: String, toScreen: String) {
        Log.d("AnalyticsHelper", "Transition from $fromScreen to $toScreen")

    }
    fun appContentButtonClicked(screen: String, action: String) {
        Log.d("AppContent", "Button from screen: $screen is action: $action")
    }
    fun loginScreenButtonClicked(screen: String, action: String) {
        Log.d("LoginScreen", "Transition from $screen to $action")
    }
}