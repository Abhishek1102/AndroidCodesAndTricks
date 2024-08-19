package com.example.androidcodesandtricks.activity

import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidcodesandtricks.R
import com.example.androidcodesandtricks.adapter.SecretCodesDetailAdapter
import com.example.androidcodesandtricks.databinding.ActivitySecretCodesDetailBinding
import com.example.androidcodesandtricks.model.SecretCodesDetailModel


class SecretCodesDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecretCodesDetailBinding
    private lateinit var secretCodesDetailAdapter: SecretCodesDetailAdapter
    private lateinit var secretCodesDetailList: ArrayList<SecretCodesDetailModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecretCodesDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViews()
    }

    private fun initViews() {

        secretCodesDetailList = ArrayList()
        val secretCodeCompanyName = intent.getStringExtra("SECRET_CODE_TITLE")

        if (secretCodeCompanyName == "Samsung") {

            secretCodesDetailList.add(
                SecretCodesDetailModel(
                    title = "Display IMEI number",
                    code = "*#06#",
                    null
                )
            )

            secretCodesDetailList.add(
                SecretCodesDetailModel(
                    "Display the Specific Absorption Rate(SAR) value of the device",
                    "*#07#",
                    null
                )
            )

            secretCodesDetailList.add(
                SecretCodesDetailModel(
                    "Display calendar storage info",
                    "*#*#225#*#*",
                    null
                )
            )

            secretCodesDetailList.add(
                SecretCodesDetailModel(
                    "Google play Services",
                    "*#*#426#*#*",
                    null
                )
            )

            secretCodesDetailList.add(
                SecretCodesDetailModel(
                    "Display information about Android Phone Battery and Usage statistics",
                    "*#*#4636#*#*",
                    null
                )
            )

            secretCodesDetailList.add(SecretCodesDetailModel("Rlz Debug UI", "*#*#759#*#*", null))

            secretCodesDetailList.add(
                SecretCodesDetailModel(
                    "Test RGB Receiver,Vibration,Touch,Speakers,Camera Sensors,Software version,etc",
                    "*#0*#",
                    null
                )
            )

            secretCodesDetailList.add(
                SecretCodesDetailModel(
                    "Change USB settings",
                    "*#0808#",
                    null
                )
            )

            secretCodesDetailList.add(
                SecretCodesDetailModel(
                    "Check Battery status ADC,RSSI reading,etc",
                    "*#0228#",
                    null
                )
            )

            secretCodesDetailList.add(
                SecretCodesDetailModel(
                    "View GSM status information",
                    "*#0011#",
                    null
                )
            )

            secretCodesDetailList.add(
                SecretCodesDetailModel(
                    "Check Hardware Version",
                    "*#2222#",
                    null
                )
            )

            secretCodesDetailList.add(
                SecretCodesDetailModel(
                    "Software Version such as PDA,CSC,MODEM,etc",
                    "*#1234#", null
                )
            )
            secretCodesDetailList.add(SecretCodesDetailModel("Check Dump mode", "*#9090#", null))
            secretCodesDetailList.add(
                SecretCodesDetailModel(
                    "Check Software and Hardware information",
                    "*#12580*369#", null
                )
            )
            secretCodesDetailList.add(
                SecretCodesDetailModel(
                    "Check Audio loopback control",
                    "*#0283#", null
                )
            )
            secretCodesDetailList.add(
                SecretCodesDetailModel(
                    "Update Camera firmware",
                    "*#34971539#", null
                )
            )
            secretCodesDetailList.add(
                SecretCodesDetailModel(
                    "Check Network lock keycode",
                    "*#7465625*638*#", null
                )
            )
            secretCodesDetailList.add(
                SecretCodesDetailModel(
                    "Check TSP and TSK firmware update",
                    "*#2663#", null
                )
            )
            secretCodesDetailList.add(
                SecretCodesDetailModel(
                    "Check Product code",
                    "*#272IMEI#*",
                    null
                )
            )
            secretCodesDetailList.add(
                SecretCodesDetailModel(
                    "Check buyer code,CSC (Country/Carrier Specific Product) Code",
                    "*#272IMEI#", null
                )
            )
            secretCodesDetailList.add(
                SecretCodesDetailModel(
                    "Check software version",
                    "*#1111#",
                    null
                )
            )
            secretCodesDetailList.add(
                SecretCodesDetailModel(
                    "View Camera firmware menu",
                    "*#1234#", null
                )
            )
            secretCodesDetailList.add(SecretCodesDetailModel("Enable call waiting", "*43#", null))
            secretCodesDetailList.add(SecretCodesDetailModel("Turn off call waiting", "#43#", null))
            secretCodesDetailList.add(
                SecretCodesDetailModel(
                    "Show status of call waiting",
                    "*#43#", null
                )
            )
            secretCodesDetailList.add(
                SecretCodesDetailModel(
                    "Request own phone number (doesn't work sometimes)",
                    "*135#", null
                )
            )
            secretCodesDetailList.add(
                SecretCodesDetailModel(
                    "Change device PIN.Replace the old and new PINs of your Samsung device",
                    "**04*[old Pin]*[new Pin]*[new Pin]#", null
                )
            )
            secretCodesDetailList.add(
                SecretCodesDetailModel(
                    "Divert call to a given number.Replace[number] with a phone number",
                    "*#004*[number]#", null
                )
            )
            secretCodesDetailList.add(
                SecretCodesDetailModel(
                    "Request the status for call diversion",
                    "*#004#", null
                )
            )
            secretCodesDetailList.add(
                SecretCodesDetailModel(
                    "Deactivate call diversion",
                    "#004#",
                    null
                )
            )

            secretCodesDetailList.add(
                SecretCodesDetailModel(
                    "Erase call diversion",
                    "*#004#",
                    null
                )
            )
        } else if (secretCodeCompanyName == "Motorola") {
            secretCodesDetailList.add(SecretCodesDetailModel("Display IMEI number", "*#06#", null))
            secretCodesDetailList.add(
                SecretCodesDetailModel(
                    "For cqa test moto E4 and all Motorola phones",
                    "*#*#2486#*#*",
                    null
                )
            )
            secretCodesDetailList.add(SecretCodesDetailModel("For Epst Menu", "##778(+call)", null))
            secretCodesDetailList.add(
                SecretCodesDetailModel(
                    "Display the Specific Absorption Rate(SAR) value of the device",
                    "*#07#",
                    null
                )
            )
            secretCodesDetailList.add(
                SecretCodesDetailModel(
                    "Display calendar storage info",
                    "*#*#225#*#*",
                    null
                )
            )
            secretCodesDetailList.add(
                SecretCodesDetailModel(
                    "Google play Services",
                    "*#*#426#*#*",
                    null
                )
            )
            //////
            secretCodesDetailList.add(
                SecretCodesDetailModel(
                    "Cancel all diverts",
                    "##002#",
                    "Call Forwarding (you have to order the services from the operator)"
                )
            )
            secretCodesDetailList.add(
                SecretCodesDetailModel(
                    "Cancel all conditional call forwarding",
                    "*#004#",
                    null
                )
            )
            secretCodesDetailList.add(
                SecretCodesDetailModel(
                    "Activate all conditional call forwarding",
                    "**004*phone number #",
                    null
                )
            )
            //////
            secretCodesDetailList.add(
                SecretCodesDetailModel(
                    "Switch off and deactivate",
                    "###61",
                    "Diversion in case of no answer"
                )
            )
            secretCodesDetailList.add(SecretCodesDetailModel("Deactivate", "#61#", null))
            secretCodesDetailList.add(
                SecretCodesDetailModel(
                    "Enable and Activate",
                    "**61* phone number #",
                    null
                )
            )
            secretCodesDetailList.add(SecretCodesDetailModel("Activate", "*61#", null))
            secretCodesDetailList.add(SecretCodesDetailModel("Check the condition", "*#61#", null))
            //////
            secretCodesDetailList.add(
                SecretCodesDetailModel(
                    "Switch off and deactivate",
                    "###21",
                    "Unconditional call forwarding(call forward All)"
                )
            )
            secretCodesDetailList.add(SecretCodesDetailModel("Deactivate", "#21#", null))
            secretCodesDetailList.add(
                SecretCodesDetailModel(
                    "Enable and activate",
                    "**21* phone number #",
                    null
                )
            )
            secretCodesDetailList.add(SecretCodesDetailModel("Activate", "*21#", null))
            secretCodesDetailList.add(SecretCodesDetailModel("Check the condition", "*#21#", null))
            /////
            secretCodesDetailList.add(
                SecretCodesDetailModel(
                    "Switch off and deactivate",
                    "###62",
                    "Diversion in case of not available"
                )
            )
            secretCodesDetailList.add(SecretCodesDetailModel("Deactivate", "#62#", null))
            secretCodesDetailList.add(
                SecretCodesDetailModel(
                    "Enable and Activate",
                    "**62* phone number #",
                    null
                )
            )
            secretCodesDetailList.add(SecretCodesDetailModel("Activate", "*62#", null))
            secretCodesDetailList.add(SecretCodesDetailModel("Check the condition", "*#62#", null))
            /////
            secretCodesDetailList.add(
                SecretCodesDetailModel(
                    "Switch off and deactivate",
                    "###67",
                    "Diversion in case of busy"
                )
            )
            secretCodesDetailList.add(SecretCodesDetailModel("Deactivate", "#67#", null))
            secretCodesDetailList.add(
                SecretCodesDetailModel(
                    "Enable and Activate",
                    "**67* phone number #",
                    null
                )
            )
            secretCodesDetailList.add(SecretCodesDetailModel("Activate", "*67#", null))
            secretCodesDetailList.add(SecretCodesDetailModel("Check the condition", "*#67#", null))
            /////
            secretCodesDetailList.add(
                SecretCodesDetailModel(
                    "Activate",
                    "*43#",
                    "Call waiting(you have to order the services from the operator)"
                )
            )
            secretCodesDetailList.add(SecretCodesDetailModel("Deactivate", "#43#", null))
            secretCodesDetailList.add(SecretCodesDetailModel("Check the condition", "*#43#", null))

        } else if (secretCodeCompanyName == "LG") {
            secretCodesDetailList.add(SecretCodesDetailModel("Display IMEI number", "*#06#", null))
            secretCodesDetailList.add(
                SecretCodesDetailModel(
                    "Display the Specific Absorption Rate(SAR) value of the device",
                    "*#07#",
                    null
                )
            )
            secretCodesDetailList.add(
                SecretCodesDetailModel(
                    "Display calendar storage info",
                    "*#*#225#*#*",
                    null
                )
            )
            secretCodesDetailList.add(
                SecretCodesDetailModel(
                    "Display information about Android Phone Battery and Usage statistics",
                    "*#*#4636#*#*",
                    null
                )
            )
            secretCodesDetailList.add(SecretCodesDetailModel("Rlz Debug UI", "*#*#759#*#*", null))
            secretCodesDetailList.add(SecretCodesDetailModel("Device Test", "*#546368#*", null))
            secretCodesDetailList.add(
                SecretCodesDetailModel(
                    "Quick GPS Test",
                    "*#*#142365#*#*",
                    null
                )
            )

            // Call forwarding codes
            secretCodesDetailList.add(
                SecretCodesDetailModel(
                    "Cancel all diverts",
                    "*#002#",
                    "Call Forwarding (you have to order the services from the operator)"
                )
            )
            secretCodesDetailList.add(
                SecretCodesDetailModel(
                    "Cancel all conditional call forwarding",
                    "##004#",
                    null
                )
            )
            secretCodesDetailList.add(
                SecretCodesDetailModel(
                    "Activate all conditional call forwarding",
                    "**004*phone number #",
                    null
                )
            )

            // Call forwarding when no answer
            secretCodesDetailList.add(
                SecretCodesDetailModel(
                    "Switch off and deactivate",
                    "###61",
                    "Diversion in case of no answer"
                )
            )
            secretCodesDetailList.add(SecretCodesDetailModel("Deactivate", "#61#", null))
            secretCodesDetailList.add(
                SecretCodesDetailModel(
                    "Enable and Activate",
                    "**61* phone number #",
                    null
                )
            )
            secretCodesDetailList.add(SecretCodesDetailModel("Activate", "*61#", null))
            secretCodesDetailList.add(SecretCodesDetailModel("Check the condition", "*#61#", null))

            // Unconditional call forwarding
            secretCodesDetailList.add(
                SecretCodesDetailModel(
                    "Switch off and deactivate",
                    "###21",
                    "Unconditional call forwarding(call forward All)"
                )
            )
            secretCodesDetailList.add(SecretCodesDetailModel("Deactivate", "#21#", null))
            secretCodesDetailList.add(
                SecretCodesDetailModel(
                    "Enable and activate",
                    "**21* phone number #",
                    null
                )
            )
            secretCodesDetailList.add(SecretCodesDetailModel("Activate", "*21#", null))
            secretCodesDetailList.add(SecretCodesDetailModel("Check the condition", "*#21#", null))

            // Call forwarding when not available
            secretCodesDetailList.add(
                SecretCodesDetailModel(
                    "Switch off and deactivate",
                    "###62",
                    "Diversion in case of not available"
                )
            )
            secretCodesDetailList.add(SecretCodesDetailModel("Deactivate", "#62#", null))
            secretCodesDetailList.add(
                SecretCodesDetailModel(
                    "Enable and Activate",
                    "**62* phone number #",
                    null
                )
            )
            secretCodesDetailList.add(SecretCodesDetailModel("Activate", "*62#", null))
            secretCodesDetailList.add(SecretCodesDetailModel("Check the condition", "*#62#", null))

            // Call forwarding when busy
            secretCodesDetailList.add(
                SecretCodesDetailModel(
                    "Switch off and deactivate",
                    "###67",
                    "Diversion in case of busy"
                )
            )
            secretCodesDetailList.add(SecretCodesDetailModel("Deactivate", "#67#", null))
            secretCodesDetailList.add(
                SecretCodesDetailModel(
                    "Enable and Activate",
                    "**67* phone number #",
                    null
                )
            )
            secretCodesDetailList.add(SecretCodesDetailModel("Activate", "*67#", null))
            secretCodesDetailList.add(SecretCodesDetailModel("Check the condition", "*#67#", null))

            // Call waiting
            secretCodesDetailList.add(
                SecretCodesDetailModel(
                    "Activate",
                    "*43#",
                    "Call waiting (you have to order the services from the operator)"
                )
            )
            secretCodesDetailList.add(SecretCodesDetailModel("Deactivate", "#43#", null))
            secretCodesDetailList.add(SecretCodesDetailModel("Check the condition", "*#43#", null))
        } else if (secretCodeCompanyName == "Nokia") {
            secretCodesDetailList.add(SecretCodesDetailModel("Display IMEI number", "*#06#", null))
            secretCodesDetailList.add(
                SecretCodesDetailModel(
                    "Display the Specific Absorption Rate(SAR) value of the device",
                    "*#07#",
                    null
                )
            )
            secretCodesDetailList.add(
                SecretCodesDetailModel(
                    "Display calendar storage info",
                    "*#*#225#*#*",
                    null
                )
            )
            secretCodesDetailList.add(
                SecretCodesDetailModel(
                    "Google Play Services",
                    "*#*#426#*#*",
                    null
                )
            )
            secretCodesDetailList.add(
                SecretCodesDetailModel(
                    "Display information about Android Phone Battery and Usage statistics",
                    "*#*#4636#*#*",
                    null
                )
            )
            secretCodesDetailList.add(SecretCodesDetailModel("Rlz Debug UI", "*#*#759#*#*", null))
            secretCodesDetailList.add(
                SecretCodesDetailModel(
                    "Cancel all diverts",
                    "##002#",
                    "Call Forwarding (you have to order the services from the operator)"
                )
            )
            secretCodesDetailList.add(
                SecretCodesDetailModel(
                    "Cancel all conditional call forwarding",
                    "##004#",
                    null
                )
            )
            secretCodesDetailList.add(
                SecretCodesDetailModel(
                    "Activate all conditional call forwarding",
                    "**004*phone number #",
                    null
                )
            )
            secretCodesDetailList.add(
                SecretCodesDetailModel(
                    "Switch off and deactivate",
                    "###61",
                    "Diversion in case of no answer"
                )
            )
            secretCodesDetailList.add(SecretCodesDetailModel("Deactivate", "#61#", null))
            secretCodesDetailList.add(
                SecretCodesDetailModel(
                    "Enable and Activate",
                    "**61* phone number #",
                    null
                )
            )
            secretCodesDetailList.add(SecretCodesDetailModel("Activate", "*61#", null))
            secretCodesDetailList.add(SecretCodesDetailModel("Check the condition", "*#61#", null))
            secretCodesDetailList.add(
                SecretCodesDetailModel(
                    "Switch off and deactivate",
                    "###21",
                    "Unconditional call forwarding (call forward All)"
                )
            )
            secretCodesDetailList.add(SecretCodesDetailModel("Deactivate", "#21#", null))
            secretCodesDetailList.add(
                SecretCodesDetailModel(
                    "Enable and activate",
                    "**21* phone number #",
                    null
                )
            )
            secretCodesDetailList.add(SecretCodesDetailModel("Activate", "*21#", null))
            secretCodesDetailList.add(SecretCodesDetailModel("Check the condition", "*#21#", null))
            secretCodesDetailList.add(
                SecretCodesDetailModel(
                    "Switch off and deactivate",
                    "###62",
                    "Diversion in case of not available"
                )
            )
            secretCodesDetailList.add(SecretCodesDetailModel("Deactivate", "#62#", null))
            secretCodesDetailList.add(
                SecretCodesDetailModel(
                    "Enable and Activate",
                    "**62* phone number #",
                    null
                )
            )
            secretCodesDetailList.add(SecretCodesDetailModel("Activate", "*62#", null))
            secretCodesDetailList.add(SecretCodesDetailModel("Check the condition", "*#62#", null))
            secretCodesDetailList.add(
                SecretCodesDetailModel(
                    "Switch off and deactivate",
                    "###67",
                    "Diversion in case of busy"
                )
            )
            secretCodesDetailList.add(SecretCodesDetailModel("Deactivate", "#67#", null))
            secretCodesDetailList.add(
                SecretCodesDetailModel(
                    "Enable and Activate",
                    "**67* phone number #",
                    null
                )
            )
            secretCodesDetailList.add(SecretCodesDetailModel("Activate", "*67#", null))
            secretCodesDetailList.add(SecretCodesDetailModel("Check the condition", "*#67#", null))
            secretCodesDetailList.add(
                SecretCodesDetailModel(
                    "Activate",
                    "*43#",
                    "Call waiting (you have to order the services from the operator)"
                )
            )
            secretCodesDetailList.add(SecretCodesDetailModel("Deactivate", "#43#", null))
            secretCodesDetailList.add(SecretCodesDetailModel("Check the condition", "*#43#", null))
        } else {
            secretCodesDetailList.add(SecretCodesDetailModel("Display IMEI number", "*#06#", null))
            secretCodesDetailList.add(
                SecretCodesDetailModel(
                    "Display the Specific Absorption Rate (SAR) value of the device",
                    "*#07#",
                    null
                )
            )
            secretCodesDetailList.add(
                SecretCodesDetailModel(
                    "Display calendar storage info",
                    "*#*#225#*#*",
                    null
                )
            )
            secretCodesDetailList.add(
                SecretCodesDetailModel(
                    "Google Play Services",
                    "*#*#426#*#*",
                    null
                )
            )
            secretCodesDetailList.add(
                SecretCodesDetailModel(
                    "Display information about Android Phone Battery and Usage statistics",
                    "*#*#4636#*#*",
                    null
                )
            )
            secretCodesDetailList.add(
                SecretCodesDetailModel(
                    "Rlx Debug UI",
                    "*#*#759#*#*",
                    null
                )
            )
            secretCodesDetailList.add(
                SecretCodesDetailModel(
                    "About Phone",
                    "*#*#0000#*#*",
                    null
                )
            )
            secretCodesDetailList.add(
                SecretCodesDetailModel(
                    "Product info, GPS, Auto/Manual Test, Software Version, etc",
                    "*#899#",
                    null
                )
            )
            secretCodesDetailList.add(
                SecretCodesDetailModel(
                    "Color OS Version",
                    "*#1234#",
                    null
                )
            )
            secretCodesDetailList.add(
                SecretCodesDetailModel(
                    "Software Version",
                    "*#6776#",
                    null
                )
            )
            secretCodesDetailList.add(
                SecretCodesDetailModel(
                    "Engineering mode(PCB NUM)",
                    "*#888#",
                    null
                )
            )

            secretCodesDetailList.add(SecretCodesDetailModel("Bugs Report", "*#800#", null))

            secretCodesDetailList.add(
                SecretCodesDetailModel(
                    "Charging Or Battery Info",
                    "*#*#6485#*#*",
                    null
                )
            )

            secretCodesDetailList.add(SecretCodesDetailModel("QC Test", "*#*#64663#*#*", null))

            secretCodesDetailList.add(
                SecretCodesDetailModel(
                    "Cancel all diverts",
                    "##002#",
                    "Call Forwarding (you have to order the services from the operator)"
                )
            )
            secretCodesDetailList.add(
                SecretCodesDetailModel(
                    "Cancel all conditional call forwarding",
                    "##004#",
                    null
                )
            )
            secretCodesDetailList.add(
                SecretCodesDetailModel(
                    "Activate all conditional call forwarding",
                    "**004*phone number#",
                    null
                )
            )
            secretCodesDetailList.add(
                SecretCodesDetailModel(
                    "Switch off and deactivate",
                    "###61",
                    "Diversion in case of no answer"
                )
            )
            secretCodesDetailList.add(SecretCodesDetailModel("Deactivate", "#61#", null))
            secretCodesDetailList.add(
                SecretCodesDetailModel(
                    "Enable and Activate",
                    "**61*phone number#",
                    null
                )
            )
            secretCodesDetailList.add(SecretCodesDetailModel("Activate", "*61#", null))
            secretCodesDetailList.add(SecretCodesDetailModel("Check the condition", "*#61#", null))
            secretCodesDetailList.add(
                SecretCodesDetailModel(
                    "Switch off and deactivate",
                    "###21",
                    "Unconditional call forwarding (call forward All)"
                )
            )
            secretCodesDetailList.add(SecretCodesDetailModel("Deactivate", "#21#", null))
            secretCodesDetailList.add(
                SecretCodesDetailModel(
                    "Enable and activate",
                    "**21*phone number#",
                    null
                )
            )
            secretCodesDetailList.add(SecretCodesDetailModel("Activate", "*21#", null))
            secretCodesDetailList.add(SecretCodesDetailModel("Check the condition", "*#21#", null))
            secretCodesDetailList.add(
                SecretCodesDetailModel(
                    "Switch off and deactivate",
                    "###62",
                    "Diversion in case of not available"
                )
            )
            secretCodesDetailList.add(SecretCodesDetailModel("Deactivate", "#62#", null))
            secretCodesDetailList.add(
                SecretCodesDetailModel(
                    "Enable and Activate",
                    "**62*phone number#",
                    null
                )
            )
            secretCodesDetailList.add(SecretCodesDetailModel("Activate", "*62#", null))
            secretCodesDetailList.add(SecretCodesDetailModel("Check the condition", "*#62#", null))
            secretCodesDetailList.add(
                SecretCodesDetailModel(
                    "Switch off and deactivate",
                    "###67",
                    "Diversion in case of busy"
                )
            )
            secretCodesDetailList.add(SecretCodesDetailModel("Deactivate", "#67#", null))
            secretCodesDetailList.add(
                SecretCodesDetailModel(
                    "Enable and Activate",
                    "**67*phone number#",
                    null
                )
            )
            secretCodesDetailList.add(SecretCodesDetailModel("Activate", "*67#", null))
            secretCodesDetailList.add(SecretCodesDetailModel("Check the condition", "*#67#", null))
            secretCodesDetailList.add(
                SecretCodesDetailModel(
                    "Activate",
                    "*43#",
                    "Call waiting (you have to order the services from the operator)"
                )
            )
            secretCodesDetailList.add(SecretCodesDetailModel("Deactivate", "#43#", null))
            secretCodesDetailList.add(SecretCodesDetailModel("Check the condition", "*#43#", null))
        }


        binding.ivBack.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        ///////////////////////////////////////////////////////

        binding.tvSecretCodesDetailCompanyName.setText(secretCodeCompanyName)


        //setting up secret codes list grid recycler view layout manager and adapter and passing list to adapter
        binding.rvSecretCodesDetail.layoutManager = LinearLayoutManager(this)
        secretCodesDetailAdapter = SecretCodesDetailAdapter(this, secretCodesDetailList)
        secretCodesDetailAdapter.notifyDataSetChanged()
        binding.rvSecretCodesDetail.adapter = secretCodesDetailAdapter


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