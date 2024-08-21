package com.example.androidcodesandtricks.activity

import android.app.Application
import com.google.android.gms.ads.MobileAds

class MyApp: Application() {

    override fun onCreate() {
        super.onCreate()
        MobileAds.initialize(this) {}
    }

}