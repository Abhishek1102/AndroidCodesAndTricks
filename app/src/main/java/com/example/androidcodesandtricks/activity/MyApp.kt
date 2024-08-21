package com.example.androidcodesandtricks.activity

import android.app.Application
import com.example.androidcodesandtricks.helper.AppOpenAdManager
import com.google.android.gms.ads.MobileAds

class MyApp: Application() {

    private lateinit var appOpenAdManager: AppOpenAdManager

    override fun onCreate() {
        super.onCreate()
        try{
            MobileAds.initialize(this) {}
            appOpenAdManager = AppOpenAdManager(this)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

}