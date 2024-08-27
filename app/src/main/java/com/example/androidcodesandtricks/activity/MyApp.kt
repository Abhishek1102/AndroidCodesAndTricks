package com.example.androidcodesandtricks.activity

import android.app.Application
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import com.example.androidcodesandtricks.helper.SecurePreferences
import com.example.androidcodesandtricks.model.AdsModel
import com.example.emicalculator.AppOpenManager
import com.example.mygreetingsapp.helper.AppConstant
import com.google.android.gms.ads.MobileAds
import com.google.firebase.firestore.FirebaseFirestore

class MyApp: Application() {

    private lateinit var appOpenAdManager: AppOpenManager
    private lateinit var firestore: FirebaseFirestore

    override fun onCreate() {
        super.onCreate()

//        dark mode logic
//        -------------------------------------------------
        val isDarkModeOn = SecurePreferences.getBooleanPreference(this, AppConstant.IS_DARK_MODE_ON)
        // Apply the theme based on the preference
        if (isDarkModeOn) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }

//        -----------------------------------------------

        firestore = FirebaseFirestore.getInstance()
        firestore.collection("ads").document("nULSpjG3mj94mMfKTWOb").addSnapshotListener { value, error ->
            if(error!=null){
                Toast.makeText(this, error.localizedMessage ?: "Error in getting data", Toast.LENGTH_SHORT).show()
            } else {
                val data: AdsModel? = value?.toObject(AdsModel::class.java)

                if(data!=null) {
                    //if ad status is true then only app open ad is initialized
                    if(data.ad_status) {
                        try{
                            MobileAds.initialize(this) {
                                appOpenAdManager = AppOpenManager(this)
                                appOpenAdManager.showAdOnAppStart()
                            }
                        } catch (e: Exception) {
                            e.printStackTrace()
                        }
                    }
                }

            }
        }

    }

    override fun onTerminate() {
        super.onTerminate()
        appOpenAdManager.cleanup()
    }

}