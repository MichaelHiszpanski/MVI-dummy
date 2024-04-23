package com.example.mvp_dummy

import android.app.Application
import androidx.multidex.MultiDex
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MyApplication : Application() {
//    override fun onCreate() {
//        super.onCreate()
////      MultiDex.install(this)
//    }
}