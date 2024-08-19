package com.example.androidcodesandtricks.activity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidcodesandtricks.R
import com.example.androidcodesandtricks.adapter.AboutDeviceAdapter
import com.example.androidcodesandtricks.adapter.CountryCodeAdapter
import com.example.androidcodesandtricks.adapter.SettingsAdapter
import com.example.androidcodesandtricks.databinding.ActivitySettingsBinding
import com.example.androidcodesandtricks.model.SettingsModel
import com.example.androidcodesandtricks.model.loadCountryData

class SettingsActivity : AppCompatActivity() {

    private lateinit var binding:ActivitySettingsBinding
    private lateinit var settingsAdapter: SettingsAdapter
    private lateinit var settingsList: ArrayList<SettingsModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViews()

    }

    private fun initViews() {

        settingsList = ArrayList()

        settingsList.add(SettingsModel(R.drawable.share, "Share App"))
        settingsList.add(SettingsModel(R.drawable.rate_us, "Rate Us"))
        settingsList.add(SettingsModel(R.drawable.privacy_policy, "Privacy Policy"))

        binding.ivBack.setOnClickListener {

            onBackPressedDispatcher.onBackPressed()

        }

        //setting up device info list linear recycler view layout manager and adapter and passing list to adapter
        val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rvSettings.layoutManager = linearLayoutManager
        settingsAdapter = SettingsAdapter(this, settingsList)
        binding.rvSettings.adapter = settingsAdapter
        settingsAdapter.notifyDataSetChanged()


    }
}