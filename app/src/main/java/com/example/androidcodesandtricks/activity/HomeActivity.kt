package com.example.androidcodesandtricks.activity

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.View
import android.widget.GridLayout
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.androidcodesandtricks.R
import com.example.androidcodesandtricks.adapter.TrendingListAdapter
import com.example.androidcodesandtricks.databinding.ActivityHomeBinding
import com.example.androidcodesandtricks.fragments.AboutDeviceFragment
import com.example.androidcodesandtricks.fragments.CountryCodeFragment
import com.example.androidcodesandtricks.fragments.HomeFragment
import com.example.androidcodesandtricks.model.TrendingListModel
import com.example.androidcodesandtricks.helper.loadBannerAds
import com.example.mygreetingsapp.helper.AppConstant
import com.google.android.gms.ads.AdSize

class HomeActivity : AppCompatActivity() {

    lateinit var binding:ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViews()

    }

    private fun initViews() {

        addfragment(HomeFragment(), "HomeFragment")

//        AdSize BANNER
        loadBannerAds(this, binding.frameAdBanner, AdSize.BANNER, AppConstant.FIXED_SIZE_BANNER_TEST_ID)

//        AdSize FULL_BANNERgit add .
//        loadBannerAds(this, binding.frameAdBanner, AdSize.FULL_BANNER, AppConstant.FIXED_SIZE_BANNER_TEST_ID)

//        AdSize LARGE_BANNER
//        loadBannerAds(this, binding.frameAdBanner, AdSize.LARGE_BANNER, AppConstant.FIXED_SIZE_BANNER_TEST_ID)

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