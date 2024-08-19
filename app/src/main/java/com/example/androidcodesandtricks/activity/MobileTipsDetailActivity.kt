package com.example.androidcodesandtricks.activity

import android.os.Bundle
import android.text.Html
import androidx.appcompat.app.AppCompatActivity
import com.example.androidcodesandtricks.databinding.ActivityMobileTipsDetailBinding
import java.io.BufferedReader
import java.io.InputStreamReader

class MobileTipsDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMobileTipsDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMobileTipsDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViews()
    }

    private fun initViews() {

        val mobileTipsTitle = intent.getStringExtra("MOBILE_TIPS_TITLE")

        val fileName = when (mobileTipsTitle) {
            "Add Internet Speed Indicator" -> "add_internet_speed.txt"
            "Add Owner Info" -> "add_owner_information.txt"
            "First Few Things" -> "first_few_things_to_do.txt"
            "Gesture Setting" -> "gesture_settings.txt"
            "Google Commands" -> "google_now_commands.txt"
            "Manage Memory" -> "manage_memory.txt"
            "Device Performance" -> "optimizing_device_preformace.txt"
            "General App Tips" -> "other_general_app.txt"
            "Privacy and Security" -> "privacy_and_security.txt"
            "Reduce Your Mobile Data Usage" -> "reduce_your_mobile_data_usage_on_android.txt"
            "Speed up Android" -> "speed_up_andriod.txt"
            "Use of OTG" -> "use_of_otg.txt"
            "Using Google Now" -> "using_google_now.txt"
            "Get Longer Battery" -> "get_longer_battery_on_your_smartphone.txt"
            "Turning Off Power" -> "save_battery_byturning_power-draining_apps.txt"
            "Turn Off Batter Services" -> "turn_off_battery_draining_services.txt"
            "Add Hard to Type Words" -> "add_hard_to_type_words_to_your_dictionary.txt"
            "Data Limit Warning" -> "getwarning_when_you_are_over_your_data_limit.txt"
            "Lost Phone Back" -> "get_your_lost_phone_back.txt"
            "Magical Tips And Tricks" -> "magical_tips_and_tricks.txt"
            "Miscellaneous" -> "miscellaneous.txt"
            "Remote Access" -> "remote_access_from_android_device.txt"
            "Remotely Delete Android Phone" -> "remoely_delete_android_phone.txt"
            "Search with your Voice" -> "search_with_your_voice.txt"
            "Quick Responses Missed Calls" -> "setquick_responese_for_missed_calls.txt"
            "Automatic Phone Unlock" -> "set_up_automatic_phoneunlock_wen_youare_at_home.txt"
            "Android Techniques" -> "some_more_android_techniques.txt"
            "Solving Screen Freeze" -> "tips_for_solvingscreen_freeze_problem.txt"
            "Keep Device Malware Free" -> "tips_to_keep_your_device_malware_free.txt"
            "Protect Your Phone if Get Stolen" -> "tips_to_protect_your_phone_if_its_gets_stolen.txt"
            "Useful Contact Tips" -> "useful_contact_dialing_tips.txt"
            "Add Your Second Languages" -> "add_your_second_language.txt"
            "Adjust Font Screen Size" -> "adjust_front_and_screen_size.txt"
            "Auto Free Storage Space" -> "automatically_free_up_storage_space.txt"
            "Better Notification" -> "better_notification_management.txt"
            "How to Use Data Saver" -> "how_to_use_data_saver.txt"
            "Picture in Picture Mode" -> "picture-in-picture_mode.txt"
            "Manage Android" -> "control_your_android.txt"
            "Wifi Password" -> "show_wifi_password.txt"
            "Unknown Facts" -> "unknown_facts.txt"
            "Recover Files" -> "recover_files.txt"
            "Break Pattern" -> "break_pattern.txt"
            "Tecno" -> "Tecno"
            "Unlock Pattern" -> "unlock_pattern.txt"
            else -> null
        }

        fileName?.let {
            val data = loadTextFromAsset(it)
            binding.tvMobileTipsDetailData.text = Html.fromHtml(data)
        }

        binding.ivBack.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        binding.tvMobileTipsDetailTitle.text = mobileTipsTitle
    }

    private fun loadTextFromAsset(fileName: String): String {
        return try {
            // Access the file within the "assets/text/" subdirectory
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
