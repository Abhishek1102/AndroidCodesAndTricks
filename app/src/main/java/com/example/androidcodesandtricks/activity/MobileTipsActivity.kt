package com.example.androidcodesandtricks.activity

import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.example.androidcodesandtricks.R
import com.example.androidcodesandtricks.adapter.MobileTipsAdapter
import com.example.androidcodesandtricks.adapter.SecretCodesAdapter
import com.example.androidcodesandtricks.databinding.ActivityMobileTipsBinding
import com.example.androidcodesandtricks.model.MobileTipsModel

class MobileTipsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMobileTipsBinding
    private lateinit var mobileTipsAdapter: MobileTipsAdapter
    private lateinit var mobileTipsList: ArrayList<MobileTipsModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMobileTipsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initList()
        initViews()

    }

    private fun initList() {

        mobileTipsList = ArrayList()

        mobileTipsList.add(MobileTipsModel(R.drawable.owner_info,"Add Owner Info"))
        mobileTipsList.add(MobileTipsModel(R.drawable.first_few_things,"First Few Things"))
        mobileTipsList.add(MobileTipsModel(R.drawable.gesture_setting,"Gesture Setting"))
        mobileTipsList.add(MobileTipsModel(R.drawable.google_commands,"Google Commands"))
        mobileTipsList.add(MobileTipsModel(R.drawable.speedometer,"Add Internet Speed Indicator"))
        mobileTipsList.add(MobileTipsModel(R.drawable.manage_memory,"Manage Memory"))
        mobileTipsList.add(MobileTipsModel(R.drawable.device_performance,"Device Performance"))
        mobileTipsList.add(MobileTipsModel(R.drawable.general_app_tips,"General App Tips"))
        mobileTipsList.add(MobileTipsModel(R.drawable.privacy_and_security,"Privacy and Security"))
        mobileTipsList.add(MobileTipsModel(R.drawable.reduce_mobile_data_usage,"Reduce Mobile Data Usage"))
        mobileTipsList.add(MobileTipsModel(R.drawable.speedup_android,"Speed up Android"))
        mobileTipsList.add(MobileTipsModel(R.drawable.use_of_otg,"Use of OTG"))
        mobileTipsList.add(MobileTipsModel(R.drawable.google_now,"Using Google Now"))
        mobileTipsList.add(MobileTipsModel(R.drawable.longer_battery,"Get Longer Battery"))
        mobileTipsList.add(MobileTipsModel(R.drawable.turning_off_power,"Turning Off Power"))
        mobileTipsList.add(MobileTipsModel(R.drawable.turn_off_batter_services,"Turn Off Batter Services"))
        mobileTipsList.add(MobileTipsModel(R.drawable.add_hard_type_words,"Add Hard to Type Words"))
        mobileTipsList.add(MobileTipsModel(R.drawable.data_limit_warning,"Data Limit Warning"))
        mobileTipsList.add(MobileTipsModel(R.drawable.lost_phone_back,"Lost Phone Back"))
        mobileTipsList.add(MobileTipsModel(R.drawable.magical_tips_tricks,"Magical Tips And Tricks"))
        mobileTipsList.add(MobileTipsModel(R.drawable.miscellaneous,"Miscellaneous"))
        mobileTipsList.add(MobileTipsModel(R.drawable.remote_access,"Remote Access"))
        mobileTipsList.add(MobileTipsModel(R.drawable.remotely_delete_android_phone,"Remotely Delete Android Phone"))
        mobileTipsList.add(MobileTipsModel(R.drawable.search_with_your_voice,"Search with your Voice"))
        mobileTipsList.add(MobileTipsModel(R.drawable.quick_responses_missed_calls,"Quick Responses Missed Calls"))
        mobileTipsList.add(MobileTipsModel(R.drawable.automatic_phone_unlock,"Automatic Phone Unlock"))
        mobileTipsList.add(MobileTipsModel(R.drawable.android_techniques,"Android Techniques"))
        mobileTipsList.add(MobileTipsModel(R.drawable.solving_screen_freeze,"Solving Screen Freeze"))
        mobileTipsList.add(MobileTipsModel(R.drawable.keep_device_malware_free,"Keep Device Malware Free"))
        mobileTipsList.add(MobileTipsModel(R.drawable.protect_phone_if_stolen,"Protect Your Phone if Get Stolen"))
        mobileTipsList.add(MobileTipsModel(R.drawable.useful_contact_tips,"Useful Contact Tips"))
        mobileTipsList.add(MobileTipsModel(R.drawable.add_second_language,"Add Your Second Languages"))
        mobileTipsList.add(MobileTipsModel(R.drawable.adjust_font_screen_size,"Adjust Font Screen Size"))
        mobileTipsList.add(MobileTipsModel(R.drawable.auto_free_storage_space,"Auto Free Storage Space"))
        mobileTipsList.add(MobileTipsModel(R.drawable.better_notification,"Better Notification"))
        mobileTipsList.add(MobileTipsModel(R.drawable.how_to_user_data_server,"How to Use Data Saver"))
        mobileTipsList.add(MobileTipsModel(R.drawable.picture_in_picture_mode,"Picture in Picture Mode"))

    }

    private fun initViews() {

        binding.ivBack.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        //setting up mobile tips list grid recycler view layout manager and adapter and passing list to adapter
        binding.rvMobileTips.layoutManager = GridLayoutManager(this, 3)
        mobileTipsAdapter = MobileTipsAdapter(this, mobileTipsList)
        mobileTipsAdapter.notifyDataSetChanged()
        binding.rvMobileTips.adapter = mobileTipsAdapter

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