package com.example.androidcodesandtricks.activity

import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.androidcodesandtricks.R
import com.example.androidcodesandtricks.adapter.SecretCodesAdapter
import com.example.androidcodesandtricks.databinding.ActivitySecretCodesBinding
import com.example.androidcodesandtricks.model.SecretCodesModel

class SecretCodesActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecretCodesBinding
    private lateinit var secretCodesAdapter: SecretCodesAdapter
    private lateinit var secretCodesList: ArrayList<SecretCodesModel>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecretCodesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initList()
        initViews()
    }

    private fun initList() {
        secretCodesList = ArrayList()

        secretCodesList.add(SecretCodesModel(R.drawable.samsung, "Samsung"))
        secretCodesList.add(SecretCodesModel(R.drawable.motorola, "Motorola"))
        secretCodesList.add(SecretCodesModel(R.drawable.lg, "LG"))
        secretCodesList.add(SecretCodesModel(R.drawable.nokia, "Nokia"))
        secretCodesList.add(SecretCodesModel(R.drawable.one_plus, "One Plus"))
        secretCodesList.add(SecretCodesModel(R.drawable.htc, "HTC"))
        secretCodesList.add(SecretCodesModel(R.drawable.tecno, "Tecno"))
        secretCodesList.add(SecretCodesModel(R.drawable.oppo, "Oppo"))
        secretCodesList.add(SecretCodesModel(R.drawable.huawei, "Huawei"))
        secretCodesList.add(SecretCodesModel(R.drawable.mi, "MI"))
        secretCodesList.add(SecretCodesModel(R.drawable.vivo, "Vivo"))
        secretCodesList.add(SecretCodesModel(R.drawable.realme, "Realme"))
        secretCodesList.add(SecretCodesModel(R.drawable.google, "Google"))
        secretCodesList.add(SecretCodesModel(R.drawable.sony, "Sony"))

    }

    private fun initViews() {

        binding.ivBack.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        //setting up secret codes list grid recycler view layout manager and adapter and passing list to adapter
        binding.rvSecretCodes.layoutManager = GridLayoutManager(this, 3)
        secretCodesAdapter = SecretCodesAdapter(this, secretCodesList)
        secretCodesAdapter.notifyDataSetChanged()
        binding.rvSecretCodes.adapter = secretCodesAdapter

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