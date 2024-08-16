package com.example.androidcodesandtricks.activity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.example.androidcodesandtricks.R
import com.example.androidcodesandtricks.adapter.AndroidTricksAdapter
import com.example.androidcodesandtricks.adapter.MobileTipsAdapter
import com.example.androidcodesandtricks.databinding.ActivityAndroidTricksBinding
import com.example.androidcodesandtricks.model.AndroidTricksModel

class AndroidTricksActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAndroidTricksBinding
    private lateinit var androidTricksAdapter: AndroidTricksAdapter
    private lateinit var androidTricksList: ArrayList<AndroidTricksModel>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAndroidTricksBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initList()
        initViews()

    }

    private fun initList() {

        androidTricksList = ArrayList()

        androidTricksList.add(AndroidTricksModel(R.drawable.unknown_facts,"Unknown Facts"))
        androidTricksList.add(AndroidTricksModel(R.drawable.recover_files,"Recover Files"))
        androidTricksList.add(AndroidTricksModel(R.drawable.improve_battery,"Improve Battery"))
        androidTricksList.add(AndroidTricksModel(R.drawable.break_pattern,"Break Pattern"))
        androidTricksList.add(AndroidTricksModel(R.drawable.wifi_password,"Wifi Hotspot"))
        androidTricksList.add(AndroidTricksModel(R.drawable.unlock_pattern,"Unlock Pattern"))
        androidTricksList.add(AndroidTricksModel(R.drawable.screen_magnifier,"Screen Magnifier"))
        androidTricksList.add(AndroidTricksModel(R.drawable.show_wifi_password,"Show Wifi Password"))
        androidTricksList.add(AndroidTricksModel(R.drawable.block_bluetooth,"Block Bluetooth"))
        androidTricksList.add(AndroidTricksModel(R.drawable.take_screenshot,"Take Screenshot"))
        androidTricksList.add(AndroidTricksModel(R.drawable.phone_description,"Phone Description"))
        androidTricksList.add(AndroidTricksModel(R.drawable.delete_notification,"Delete Notification"))
        androidTricksList.add(AndroidTricksModel(R.drawable.factory_reset,"Factory Reset"))
        androidTricksList.add(AndroidTricksModel(R.drawable.record_screen,"Record Screen"))
        androidTricksList.add(AndroidTricksModel(R.drawable.control_your_laptop,"Control your Laptop"))
        androidTricksList.add(AndroidTricksModel(R.drawable.radiation_level,"Radiation Level"))
        androidTricksList.add(AndroidTricksModel(R.drawable.ten_best_backup_apps,"10 Best Backup apps"))
        androidTricksList.add(AndroidTricksModel(R.drawable.backup_up_your_phones,"Backup your Phones"))

    }

    private fun initViews() {

        binding.ivBack.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        //setting up android tricks list grid recycler view layout manager and adapter and passing list to adapter
        binding.rvAndroidTricks.layoutManager = GridLayoutManager(this, 3)
        androidTricksAdapter = AndroidTricksAdapter(this, androidTricksList)
        androidTricksAdapter.notifyDataSetChanged()
        binding.rvAndroidTricks.adapter = androidTricksAdapter

    }
}