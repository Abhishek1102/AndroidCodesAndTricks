package com.example.androidcodesandtricks.activity

import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.androidcodesandtricks.R
import com.example.androidcodesandtricks.databinding.ActivityHomeBinding
import com.example.androidcodesandtricks.fragments.AboutDeviceFragment
import com.example.androidcodesandtricks.fragments.CountryCodeFragment
import com.example.androidcodesandtricks.fragments.HomeFragment
import com.example.androidcodesandtricks.helper.SecurePreferences
import com.example.androidcodesandtricks.model.AdsModel
import com.example.androidcodesandtricks.helper.loadBannerAds
import com.example.mygreetingsapp.helper.AppConstant
import com.google.android.gms.ads.AdSize
import com.google.firebase.firestore.FirebaseFirestore

class HomeActivity : AppCompatActivity() {

    lateinit var binding: ActivityHomeBinding
    lateinit var firestore: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViews()

        // Handle back press using OnBackPressedDispatcher
        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                showExitDialog()
            }
        })

    }
    private fun initViews() {

        firestore = FirebaseFirestore.getInstance()
        addfragment(HomeFragment(), "HomeFragment")

        firestore.collection("ads").document("nULSpjG3mj94mMfKTWOb")
            .addSnapshotListener { value, error ->
                if (error != null) {
                    toast("Error", error.localizedMessage ?: "Error in getting data")
                } else {
                    val data: AdsModel? = value?.toObject(AdsModel::class.java)

                    if (data != null) {
                        if (data.ad_status) {
                            //-------- if ad status is true then only ads will show ---------------

                            binding.adviewAdBanner.visibility = View.VISIBLE

//                          AdSize Adaptive BANNER
                            loadBannerAds(this, binding.adviewAdBanner, AdSize.BANNER, data.banner_g)

                            //interstitial click counter
                            SecurePreferences.savePreferences(
                                this,
                                AppConstant.INTERSTITIAL_AD_CLICK_COUNTER,
                                data.interstitial_ad_click_counter
                            )

                            Log.d("My Data", "onEvent: " + data.ad_status.toString())
                            Log.d("My Data", "onEvent: " + data.interstitial_ad_click_counter.toString()
                            )
                        } else {
                            binding.adviewAdBanner.visibility = View.GONE
                            SecurePreferences.savePreferences(this, AppConstant.INTERSTITIAL_AD_CLICK_COUNTER, "0")
                            Log.d("My Data", "onEvent: " + data.ad_status.toString())
                        }
                        // Handle the data, e.g., update UI or store data
                    } else {
                        Log.d("My Data", "onEvent: " + data?.ad_status.toString())
                        toast("Info", "No data found")
                    }
                }
            }


        binding.bottomNavigatioView.setOnItemSelectedListener {
            Log.d("HomeActivity", "MenuItem selected: ${it.itemId}")
            when (it.itemId) {
                R.id.home -> {
                    Log.d("HomeActivity", "Home selected")
                    addfragment(HomeFragment(), "HomeFragment")
                }

                R.id.about_device -> {
                    Log.d("HomeActivity", "About Device selected")
                    addfragment(AboutDeviceFragment(), "AboutDeviceFragment")
                }

                R.id.country_codes -> {
                    Log.d("HomeActivity", "Country Codes selected")
                    addfragment(CountryCodeFragment(), "CountryCodeFragment")
                }

                else -> {
                    Log.d("HomeActivity", "Unknown menu item selected")
                }
            }
            true
        }


    }

    private fun showExitDialog() {
        val dialogBuilder = android.app.AlertDialog.Builder(this)
        val inflater = layoutInflater
        val dialogView = inflater.inflate(R.layout.custom_exit_dialog, null)
        dialogBuilder.setView(dialogView)

        // Get dialog elements
        val tvTitle = dialogView.findViewById<TextView>(R.id.txt_dialog_title)
        val tvMessage = dialogView.findViewById<TextView>(R.id.txt_dialog_msg)
        val tvYes = dialogView.findViewById<TextView>(R.id.txt_positive)
        val tvNo = dialogView.findViewById<TextView>(R.id.txt_negative)

        tvTitle.setText("Exit")
        tvMessage.setText("Are you sure want to exit?")
        tvYes.setText("Yes")
        tvNo.setText("No")

        // Create and show the dialog
        val exitDialog = dialogBuilder.create()
        exitDialog.show()

        // Handle "Yes" button click
        tvYes.setOnClickListener {
            exitDialog.dismiss()
            finishAffinity() // Close the app
        }

        // Handle "No" button click
        tvNo.setOnClickListener {
            exitDialog.dismiss() // Close the dialog
        }
    }

    private fun addfragment(fragment: Fragment, tag: String) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_home, fragment, tag)
        // Do not call addToBackStack(null) to avoid adding the transaction to the back stack
        fragmentTransaction.commit()
    }


    private fun toast(type: String, desc: String) {
        val inflater = layoutInflater
        val layout: View =
            inflater.inflate(R.layout.custom_toast, findViewById(R.id.lv_customtoast))
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
        val toast = Toast(this)
        toast.duration = Toast.LENGTH_LONG
        toast.setView(layout)
        toast.setGravity(Gravity.TOP or Gravity.CENTER_HORIZONTAL, 0, 0)
        toast.show()
    }

}