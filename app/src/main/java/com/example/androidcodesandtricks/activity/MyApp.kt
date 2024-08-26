package com.example.androidcodesandtricks.activity

import android.app.Application
import com.example.emicalculator.AppOpenManager
import com.google.android.gms.ads.MobileAds

class MyApp: Application() {

    private lateinit var appOpenAdManager: AppOpenManager

    override fun onCreate() {
        super.onCreate()
        try{
            MobileAds.initialize(this) {
                appOpenAdManager = AppOpenManager(this)
                appOpenAdManager.showAdOnAppStart()
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun onTerminate() {
        super.onTerminate()
        appOpenAdManager.cleanup()
    }

}