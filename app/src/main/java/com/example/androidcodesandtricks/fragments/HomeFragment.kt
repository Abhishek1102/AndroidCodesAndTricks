package com.example.androidcodesandtricks.fragments

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat.finishAffinity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.androidcodesandtricks.R
import com.example.androidcodesandtricks.activity.AndroidTricksActivity
import com.example.androidcodesandtricks.activity.MobileTipsActivity
import com.example.androidcodesandtricks.activity.SecretCodesActivity
import com.example.androidcodesandtricks.activity.SettingsActivity
import com.example.androidcodesandtricks.adapter.TrendingListAdapter
import com.example.androidcodesandtricks.databinding.FragmentHomeBinding
import com.example.androidcodesandtricks.helper.AdClickManager
import com.example.androidcodesandtricks.helper.InterstitialAdClickCounter
import com.example.androidcodesandtricks.helper.SecurePreferences
import com.example.androidcodesandtricks.model.TrendingListModel
import com.example.mygreetingsapp.helper.AppConstant
import com.google.android.gms.ads.AdError
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.FullScreenContentCallback
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback
import com.google.firebase.remoteconfig.BuildConfig
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    lateinit var trendingListAdapter: TrendingListAdapter
    lateinit var trendingItemList: ArrayList<TrendingListModel>
    private var interstitialAd: InterstitialAd? = null
    private lateinit var interstitialAdClickCounter: InterstitialAdClickCounter
    private lateinit var firebaseRemoteConfig: FirebaseRemoteConfig

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentHomeBinding.inflate(inflater, container, false)

        initRemoteConfig()
        initList()
        initViews()

        return binding.root
    }

    private fun initList() {

        loadInterstitialAds()
        interstitialAdClickCounter = InterstitialAdClickCounter()

        trendingItemList = ArrayList()

        trendingItemList.add(TrendingListModel(R.drawable.samsung, "Samsung"))
        trendingItemList.add(TrendingListModel(R.drawable.manage_android, "Manage Android"))
        trendingItemList.add(TrendingListModel(R.drawable.vivo, "Vivo"))
        trendingItemList.add(TrendingListModel(R.drawable.owner_info, "Add Owner Info"))
        trendingItemList.add(TrendingListModel(R.drawable.lg, "LG"))
        trendingItemList.add(TrendingListModel(R.drawable.manage_memory, "Manage Memory"))
        trendingItemList.add(TrendingListModel(R.drawable.google, "Google"))
        trendingItemList.add(TrendingListModel(R.drawable.show_wifi_password, "Wifi Password"))
        trendingItemList.add(TrendingListModel(R.drawable.speedometer, "Speed up Android"))
        trendingItemList.add(TrendingListModel(R.drawable.mi, "MI"))
        trendingItemList.add(TrendingListModel(R.drawable.unknown_facts, "Unknown Facts"))
        trendingItemList.add(TrendingListModel(R.drawable.huawei, "Huawei"))
        trendingItemList.add(TrendingListModel(R.drawable.recover_files, "Recover Files"))
        trendingItemList.add(TrendingListModel(R.drawable.oppo, "Oppo"))
        trendingItemList.add(TrendingListModel(R.drawable.break_pattern, "Break Pattern"))
        trendingItemList.add(TrendingListModel(R.drawable.tecno, "Tecno Facts"))
        trendingItemList.add(TrendingListModel(R.drawable.unlock_pattern, "Unlock Pattern"))
    }

    private fun loadInterstitialAds() {
        val adRequest = AdRequest.Builder().build()
        InterstitialAd.load(requireContext(), AppConstant.INTERSTITIAL_TEST_ID, adRequest,
            object : InterstitialAdLoadCallback() {
                override fun onAdLoaded(ad: InterstitialAd) {
                    Log.d("Interstitial Ad", "Interstitial Ad Loaded")
                    interstitialAd = ad
                }

                override fun onAdFailedToLoad(adError: LoadAdError) {
                    Log.d("Interstitial Ad", "Interstitial Ad Not Loaded: ${adError.message}")
                    interstitialAd = null
                }
            })
    }

    private fun initViews() {

        binding.lvSecretCodes.setOnClickListener {

            val intent = Intent(context, SecretCodesActivity::class.java)
            startActivity(intent)

        }

        binding.lvMobileTips.setOnClickListener {

            val intent = Intent(context, MobileTipsActivity::class.java)
            startActivity(intent)
        }

        binding.lvAndroidTricks.setOnClickListener {

            val intent = Intent(context, AndroidTricksActivity::class.java)
            startActivity(intent)
        }

        binding.ivSettings.setOnClickListener {

            val intent = Intent(context, SettingsActivity::class.java)
            startActivity(intent)

        }

        //getting click counter from shared preferences
        val clickCounter = SecurePreferences.getStringPreference(
            context,
            AppConstant.INTERSTITIAL_AD_CLICK_COUNTER
        )

        //setting up trending list grid recycler view layout manager and adapter and passing list to adapter
        val gridLayoutManager = GridLayoutManager(context, 3)
        binding.rvTrendingList.layoutManager = gridLayoutManager
        trendingListAdapter = TrendingListAdapter(
            requireContext(),
            trendingItemList,
            interstitialAd,
            interstitialAdClickCounter,
            clickCounter
        )
        binding.rvTrendingList.adapter = trendingListAdapter
        trendingListAdapter.notifyDataSetChanged()

    }

    private fun initRemoteConfig() {
        firebaseRemoteConfig = FirebaseRemoteConfig.getInstance()
        val firebaseRemoteConfigSettings = FirebaseRemoteConfigSettings.Builder()
            .setMinimumFetchIntervalInSeconds(0L)
            .build()
        firebaseRemoteConfig.setConfigSettingsAsync(firebaseRemoteConfigSettings)
        firebaseRemoteConfig.setDefaultsAsync(R.xml.remote_config_default_map)
        fetchAndActivateRemoteConfig()  // Fetch Remote Config values after initializing
    }


    private fun fetchAndActivateRemoteConfig() {
        firebaseRemoteConfig.fetchAndActivate()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val newVersionCode = firebaseRemoteConfig.getString("new_version_code")
                    val isForceUpdate = firebaseRemoteConfig.getBoolean("is_force_update")
                    checkForUpdate(newVersionCode, isForceUpdate)
                } else {
                    // Handle fetch failure
                }
            }
    }

    private fun checkForUpdate(newVersionCode: String, isForceUpdate: Boolean) {

        val currentVersionCode = getVersionCode(requireContext())
        val newVersionCodeInt = newVersionCode.toLongOrNull() ?: -1L

        Log.d("ababcd", "Current Version Code: ${currentVersionCode}")
        Log.d("ababcd", "New Version Code from Remote Config is ${newVersionCode}")

        if (newVersionCodeInt > currentVersionCode) {
            showUpdateDialog(isForceUpdate) // Show update dialog if new version is available
        }
    }

    fun getVersionCode(context: Context): Long {
        val packageInfo = context.packageManager.getPackageInfo(context.packageName, 0)
        return packageInfo.longVersionCode
    }

    private fun showUpdateDialog(isForceUpdate: Boolean) {

        val appPackageName = requireContext().packageName

        val dialogBuilder = android.app.AlertDialog.Builder(context)
        val inflater = layoutInflater
        val dialogView = inflater.inflate(R.layout.custom_exit_dialog, null)
        dialogBuilder.setView(dialogView)

        // Get dialog elements
        val tvTitle = dialogView.findViewById<TextView>(R.id.txt_dialog_title)
        val tvMessage = dialogView.findViewById<TextView>(R.id.txt_dialog_msg)
        val tvUpdate = dialogView.findViewById<TextView>(R.id.txt_positive)
        val tvLater = dialogView.findViewById<TextView>(R.id.txt_negative)

        tvTitle.setText("Update")
        tvMessage.setText("New Update is available! Please update the app for new features")
        tvUpdate.setText("Update")
        tvLater.setText("Later")

        // Create and show the dialog
        val updateDialog = dialogBuilder.create()
        //making update later button visible or gone base on the isforce update is true or false
        if (isForceUpdate) {
            tvLater.visibility = View.GONE
        } else {
            tvLater.visibility = View.VISIBLE
        }
        updateDialog.show()
        updateDialog.setCancelable(false)

        // Handle "Yes" button click
        tvUpdate.setOnClickListener {
            try {
                startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("market://details?id=$appPackageName")
                    )
                )
            } catch (anfe: android.content.ActivityNotFoundException) {
                startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://play.google.com/store/apps/details?id=$appPackageName")
                    )
                )
            }
        }

        // Handle "No" button click
        tvLater.setOnClickListener {
            updateDialog.dismiss() // Close the dialog
        }
    }

//    private fun showUpdateDialog() {
//        val appPackageName = requireContext().packageName
//        val dialog = AlertDialog.Builder(requireContext())
//            .setTitle("Update")
//            .setMessage("A new version of the app is available. Please update to the latest version.")
//            .setPositiveButton("UPDATE") { _, _ ->
//                try {
//                    startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=$appPackageName")))
//                } catch (anfe: android.content.ActivityNotFoundException) {
//                    startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=$appPackageName")))
//                }
//            }
//            .setCancelable(false)
//            .create()
//        dialog.show()
//    }


    private fun toast(type: String, desc: String) {
        val inflater = layoutInflater
        val layout: View =
            inflater.inflate(R.layout.custom_toast, requireView().findViewById(R.id.lv_customtoast))
        val iv_messageimage = layout.findViewById<ImageView>(R.id.iv_messageimage)
        val tv_messagetitle = layout.findViewById<TextView>(R.id.tv_messagetitle)
        val tv_messagedesc = layout.findViewById<TextView>(R.id.tv_messagedesc)
        val lv_message = layout.findViewById<LinearLayout>(R.id.lv_message)
        if (type.equals("success", ignoreCase = true)) //success
        {
            lv_message.setBackgroundColor(resources.getColor(R.color.green2))
            //            iv_messageimage.setBackground(getResources().getDrawable(R.drawable.gradient_green));
            iv_messageimage.setImageResource(R.drawable.tick)
            tv_messagetitle.text = "Success"
            tv_messagedesc.text = desc
            tv_messagedesc.text = desc
        } else if (type.equals("info", ignoreCase = true)) //info
        {
            lv_message.setBackgroundColor(resources.getColor(R.color.colorPrimary))
            iv_messageimage.setImageResource(R.drawable.info)
            tv_messagetitle.text = "Info"
            tv_messagedesc.text = desc
            tv_messagedesc.text = desc
        } else if (type.equals("error", ignoreCase = true)) {
            lv_message.setBackgroundColor(resources.getColor(R.color.red_2))
            iv_messageimage.setImageResource(R.drawable.danger)
            tv_messagetitle.text = "Danger"
            tv_messagedesc.text = desc
        } else if (type.equals("warning", ignoreCase = true)) {
            lv_message.setBackgroundColor(resources.getColor(R.color.orange4))
            iv_messageimage.setImageResource(R.drawable.exclamation)
            tv_messagetitle.text = "Warning"
            tv_messagedesc.text = desc
        }
        val toast = Toast(context)
        toast.duration = Toast.LENGTH_LONG
        toast.view = layout
        toast.setGravity(Gravity.TOP or Gravity.CENTER_HORIZONTAL, 0, 0)
        toast.show()
    }

    fun replacefragment(fragment1: Fragment?, tag: String?) {
        val ft = requireFragmentManager().beginTransaction()
        ft.setCustomAnimations(
            R.anim.slide_in_left, R.anim.slide_out_left,
            R.anim.slide_out_right, R.anim.slide_in_right
        )
        ft.replace(R.id.frame_home, fragment1!!, tag).addToBackStack(null).commit()
    }

}