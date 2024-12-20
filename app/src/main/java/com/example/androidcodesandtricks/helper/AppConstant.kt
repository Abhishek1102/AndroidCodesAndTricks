package com.example.mygreetingsapp.helper

import android.app.ProgressDialog
import android.content.Context
import android.content.res.Configuration
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import com.example.androidcodesandtricks.R
import java.util.*

class AppConstant {

    companion object {

        //admob test ads id
        var APP_OPEN_TEST_ID = "ca-app-pub-3940256099942544/9257395921"
        var ADAPTIVE_BANNER_TEST_ID = "ca-app-pub-3940256099942544/9214589741"
        var FIXED_SIZE_BANNER_TEST_ID = "ca-app-pub-3940256099942544/6300978111"
        var INTERSTITIAL_TEST_ID = "ca-app-pub-3940256099942544/1033173712"
        var NATIVE_TEST_ID = "ca-app-pub-3940256099942544/2247696110"

        var INTERSTITIAL_AD_CLICK_COUNTER = "interstitial_ad_click_counter"
        var IS_DARK_MODE_ON = "is_dark_mode_on"

///////////////////////////////////////////////////////////////////////

        var IS_LOGIN = "is_login"
        var NAME = "name"
        var EMAIL = "email"
        var PASSWORD = "password"
        var MOBILE_NUMBER = "mobile_number"
        var OTP = "otp"

        var USER_NAME = ""
        var USER_NUMBER = ""
        var USER_EMAIL = ""
        var USER_IMAGE = ""

        var LANGUAGE = "user_language"

        lateinit var dialog:ProgressDialog

        fun setLanguage(activity: Context?) {
            val sharedPreferences =
                activity!!.getSharedPreferences("LANGUAGE_SETTING", Context.MODE_PRIVATE)
            val languageToLoad: String
            languageToLoad =
                if (sharedPreferences.getString(AppConstant.LANGUAGE, "en").equals("en", ignoreCase = true)) {
                    "en" // your language
                } else {
                    "gu"
                }
            val locale = Locale(languageToLoad)
            Locale.setDefault(locale)
            val config = Configuration()
            config.locale = locale
            activity.resources.updateConfiguration(
                config,
                activity.resources.displayMetrics
            )
        }

        fun showProgressDialog(context: Context?) {
            dialog = ProgressDialog(context)
            if (dialog.window != null) dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            dialog.isIndeterminate = true
            dialog.setCanceledOnTouchOutside(false)
            dialog.setCancelable(false)
            dialog.show()
            dialog.setContentView(R.layout.custom_progress)
        }

        fun hideProgressDialog() {
            if (dialog != null && dialog.isShowing) dialog.dismiss()
        }


    }
}