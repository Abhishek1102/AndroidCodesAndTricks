package com.example.androidcodesandtricks.activity

import android.os.Bundle
import android.text.Html
import androidx.appcompat.app.AppCompatActivity
import com.example.androidcodesandtricks.databinding.ActivityAndroidTricksDetailBinding
import java.io.BufferedReader
import java.io.InputStreamReader

class AndroidTricksDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAndroidTricksDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAndroidTricksDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViews()
    }

    private fun initViews() {
        val androidTricksDetailTitle = intent.getStringExtra("ANDROID_TRICKS_TITLE")

        val fileName = when (androidTricksDetailTitle) {
            "Unknown Facts" -> "unknown_facts.txt"
            "Recover Files" -> "recover_files.txt"
            "Improve Battery" -> "improve_battery.txt"
            "Break Pattern" -> "break_pattern.txt"
            "Wifi Hotspot" -> "wifi_hotspot.txt"
            "Unlock Pattern" -> "unlock_pattern.txt"
            "Screen Magnifier" -> "screen_magnifier.txt"
            "Show Wifi Password" -> "show_wifi_password.txt"
            "Block Bluetooth" -> "block_bluetooth.txt"
            "Take Screenshot" -> "take_screenshots.txt"
            "Phone Description" -> "phone_description.txt"
            "Delete Notification" -> "delete_notification.txt"
            "Factory Reset" -> "hard_factory_reset.txt"
            "Record Screen" -> "record_screen.txt"
            "Control your Laptop" -> "control_your_laptop.txt"
            "Radiation Level" -> "radiation_level.txt"
            "10 Best Backup apps" -> "10best_android_backup_apps.txt"
            "Backup your Phones" -> "how_to_backup_your_android_phone.txt"
            else -> null
        }

        fileName?.let {
            val data = loadTextFromAsset(it)
            binding.tvAndroidTricksDetailData.text = Html.fromHtml(data)
        }

        binding.ivBack.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        binding.tvAndroidTricksDetailTitle.text = androidTricksDetailTitle
    }

    private fun loadTextFromAsset(fileName: String): String {
        return try {
            val inputStream = assets.open("text/$fileName")
            val reader = BufferedReader(InputStreamReader(inputStream))
            val content = reader.use { it.readText() }
            content
        } catch (e: Exception) {
            e.printStackTrace()
            "Error loading file"
        }
    }
}
