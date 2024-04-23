package com.example.mvi_dummy.analytics_helper

import android.util.Log
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AnalyticsHelper @Inject constructor() {
    fun logScreenTransition(fromScreen: String, toScreen: String) {
        Log.d("AnalyticsHelper", "Transition from $fromScreen to $toScreen")

    }
}