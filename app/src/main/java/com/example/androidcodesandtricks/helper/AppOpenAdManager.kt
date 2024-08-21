package com.example.androidcodesandtricks.helper

import android.app.Activity
import android.app.Application
import android.app.Application.ActivityLifecycleCallbacks
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ProcessLifecycleOwner
import com.example.androidcodesandtricks.R
import com.example.androidcodesandtricks.activity.MyApp
import com.google.android.gms.ads.AdError
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.FullScreenContentCallback
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.appopen.AppOpenAd
import com.google.android.gms.ads.appopen.AppOpenAd.AppOpenAdLoadCallback
import java.util.Date

class AppOpenAdManager(private val application: Application) : Application.ActivityLifecycleCallbacks {

    private var appOpenAd: AppOpenAd? = null
    private var isAdLoading = false
    private var loadTime: Long = 0
    private var currentActivity: Activity? = null

    companion object {
        private const val AD_UNIT_ID = "ca-app-pub-3940256099942544/9257395921"
        private const val LOG_TAG = "AppOpenAdManager"
        private const val AD_EXPIRATION_TIME = 4 * 3600 * 1000 // 4 hours in milliseconds
    }

    init {
        application.registerActivityLifecycleCallbacks(this)
        // Preload ad when app starts
        loadAd()
    }

    private fun loadAd() {
        if (isAdLoading || isAdAvailable()) {
            return
        }

        isAdLoading = true
        val adRequest = AdRequest.Builder().build()
        AppOpenAd.load(
            application, AD_UNIT_ID, adRequest,
            AppOpenAd.APP_OPEN_AD_ORIENTATION_PORTRAIT,
            object : AppOpenAd.AppOpenAdLoadCallback() {
                override fun onAdLoaded(ad: AppOpenAd) {
                    Log.d(LOG_TAG, "Ad was loaded.")
                    appOpenAd = ad
                    loadTime = Date().time
                    isAdLoading = false
                }

                override fun onAdFailedToLoad(loadAdError: LoadAdError) {
                    Log.d(LOG_TAG, "Failed to load ad: ${loadAdError.message}")
                    isAdLoading = false
                }
            })
    }

    private fun isAdAvailable(): Boolean {
        return appOpenAd != null && Date().time - loadTime < AD_EXPIRATION_TIME
    }

    fun showAdIfAvailable(activity: Activity) {
        if (isAdAvailable()) {
            appOpenAd?.fullScreenContentCallback = object : FullScreenContentCallback() {
                override fun onAdDismissedFullScreenContent() {
                    Log.d(LOG_TAG, "Ad dismissed.")
                    appOpenAd = null
                    loadAd()
                }

                override fun onAdFailedToShowFullScreenContent(p0: AdError) {
                    Log.d(LOG_TAG, "Ad failed to show.")
                    appOpenAd = null
                    loadAd()
                }

                override fun onAdShowedFullScreenContent() {
                    Log.d(LOG_TAG, "Ad showed fullscreen content.")
                }
            }
            appOpenAd?.show(activity)
        } else {
            Log.d(LOG_TAG, "Ad is not available.")
            loadAd()
        }
    }

    override fun onActivityStarted(activity: Activity) {
        currentActivity = activity
        // Show ad when the activity is started
        showAdIfAvailable(activity)
    }

    override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
        currentActivity = activity
    }
    override fun onActivityResumed(activity: Activity) {
        currentActivity = activity
    }
    override fun onActivityPaused(activity: Activity) {
        currentActivity = null
    }
    override fun onActivityStopped(activity: Activity) {
        currentActivity = null
    }
    override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {}
    override fun onActivityDestroyed(activity: Activity) {}
}
