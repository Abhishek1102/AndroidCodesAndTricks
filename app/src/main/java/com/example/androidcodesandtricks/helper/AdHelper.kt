package com.example.androidcodesandtricks.helper

import android.content.Context
import android.view.View
import android.widget.FrameLayout
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.LoadAdError

fun loadBannerAds(context: Context, adsFrameLayout: AdView, adSize: AdSize, adUnitIdL: String) {

    val adView = AdView(context)
    adView.setAdSize(adSize)
    adView.adUnitId = adUnitIdL
    adsFrameLayout.addView(adView)

    val adRequest = AdRequest.Builder().build()
    adView.loadAd(adRequest)
    adView.adListener = object : AdListener() {
        override fun onAdFailedToLoad(adError: LoadAdError) {
            super.onAdFailedToLoad(adError)

            adsFrameLayout.gone()
            adView.loadAd(adRequest)
        }

        override fun onAdLoaded() {
            super.onAdLoaded()
            adsFrameLayout.visible()
        }
    }

}

fun View.gone() {
    visibility = View.GONE
}

fun View.visible() {
    visibility = View.VISIBLE
}

object AdClickManager {
    private var clickCount = 0
    private const val CLICK_THRESHOLD = 3

    fun incrementClickCount(): Boolean {
        clickCount++
        return clickCount >= CLICK_THRESHOLD
    }

    fun resetClickCount() {
        clickCount = 0
    }
}
