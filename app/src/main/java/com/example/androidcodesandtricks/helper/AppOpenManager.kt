package com.example.emicalculator

import android.app.Activity
import android.app.Application.ActivityLifecycleCallbacks
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ProcessLifecycleOwner
import com.example.androidcodesandtricks.R
import com.example.androidcodesandtricks.activity.MyApp
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.FullScreenContentCallback
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.appopen.AppOpenAd
import com.google.android.gms.ads.appopen.AppOpenAd.AppOpenAdLoadCallback
import java.util.Date

class AppOpenManager(private val myApp: MyApp) : ActivityLifecycleCallbacks,
    DefaultLifecycleObserver {

    private var appOpenAd: AppOpenAd? = null
    private var isShowingAd = false
    private var currentActivity: Activity? = null
    private var loadTime: Long = 0

    init {
        myApp.registerActivityLifecycleCallbacks(this)
        ProcessLifecycleOwner.get().lifecycle.addObserver(this)
        MobileAds.initialize(myApp) // Ensure MobileAds is initialized
        fetchAd() // Preload the ad
    }

    private fun wasLoadTimeLessThanNHoursAgo(): Boolean {
        val numHours = 4
        val dateDifference: Long = Date().time - loadTime
        val numMilliSecondsPerHour: Long = 3600000
        return dateDifference < numMilliSecondsPerHour * numHours
    }

    private fun isAdAvailable(): Boolean {
        return appOpenAd != null && wasLoadTimeLessThanNHoursAgo()
    }

    private fun fetchAd() {
        if (isAdAvailable()) {
            return
        }

        val loadCallback = object : AppOpenAdLoadCallback() {
            override fun onAdLoaded(appOpenAd: AppOpenAd) {
                super.onAdLoaded(appOpenAd)
                this@AppOpenManager.appOpenAd = appOpenAd
                loadTime = Date().time
                Log.d("AppOpenManager", "Ad loaded successfully")
            }

            override fun onAdFailedToLoad(loadAdError: LoadAdError) {
                Log.d("AppOpenManager", "Failed to load ad: ${loadAdError.message}")
            }
        }

        val request = AdRequest.Builder().build()
        AppOpenAd.load(
            myApp,
            myApp.getString(R.string.APP_OPEN_AD_TEST_ID),
            request,
            AppOpenAd.APP_OPEN_AD_ORIENTATION_PORTRAIT,
            loadCallback
        )
    }

    private fun showAdIfAvailable() {
        if (!isShowingAd && isAdAvailable()) {
            appOpenAd!!.fullScreenContentCallback = object : FullScreenContentCallback() {
                override fun onAdDismissedFullScreenContent() {
                    appOpenAd = null
                    isShowingAd = false
                    fetchAd()
                    Log.d("AppOpenManager", "Ad dismissed")
                }

                override fun onAdFailedToShowFullScreenContent(adError: com.google.android.gms.ads.AdError) {
                    appOpenAd = null
                    isShowingAd = false
                    Log.d("AppOpenManager", "Failed to show ad: ${adError.message}")
                }

                override fun onAdShowedFullScreenContent() {
                    isShowingAd = true
                    Log.d("AppOpenManager", "Ad showed successfully")
                }
            }
            appOpenAd!!.show(currentActivity!!)
        } else {
            fetchAd()
        }
    }

    override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
        if (!isShowingAd) {
            currentActivity = activity
        }
    }

    override fun onActivityStarted(activity: Activity) {
        if (!isShowingAd) {
            currentActivity = activity
        }
    }

    override fun onActivityResumed(activity: Activity) {
        if (!isShowingAd) {
            currentActivity = activity
        }
    }

    override fun onActivityPaused(activity: Activity) {}

    override fun onActivityStopped(activity: Activity) {}

    override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {}

    override fun onActivityDestroyed(activity: Activity) {
        if (currentActivity == activity) {
            currentActivity = null
        }
    }

    override fun onStart(owner: LifecycleOwner) {
        super.onStart(owner)
        showAdIfAvailable()
    }

    // Method to show ad on app start
    fun showAdOnAppStart() {
        if (isAdAvailable()) {
            showAdIfAvailable()
        } else {
            fetchAd()
        }
    }

    fun cleanup() {
        // Unregister activity lifecycle callbacks
        myApp.unregisterActivityLifecycleCallbacks(this)
        // Remove lifecycle observer
        ProcessLifecycleOwner.get().lifecycle.removeObserver(this)
        // Clear any other resources if necessary
    }

}
