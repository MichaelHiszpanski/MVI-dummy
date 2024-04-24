package com.example.mvi_dummy.Local

import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.staticCompositionLocalOf
import com.example.mvi_dummy.MVI.LoginMVI.LoginScreenViewModel
import com.example.mvi_dummy.analytics_helper.AnalyticsHelper


val LocalAnalyticsHelper = staticCompositionLocalOf<AnalyticsHelper> {
    error("No AnalyticsHelper provided")
}

val LocalLoginModelView = compositionLocalOf<LoginScreenViewModel> {
    error("No LoginScreenViewModel provided")
}