package com.example.androidcodesandtricks.adapter

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.androidcodesandtricks.R
import com.example.androidcodesandtricks.activity.MobileTipsDetailActivity
import com.example.androidcodesandtricks.activity.PrivacyPolicyActivity
import com.example.androidcodesandtricks.activity.SecretCodesDetailActivity
import com.example.androidcodesandtricks.activity.SettingsActivity
import com.example.androidcodesandtricks.model.SettingsModel
import com.example.androidcodesandtricks.model.TrendingListModel

class SettingsAdapter(
    private val context: Context,
    private val settingsListItem: ArrayList<SettingsModel>,
) : RecyclerView.Adapter<SettingsAdapter.TrendingListViewHolder>() {


    class TrendingListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var iv_settings: ImageView = itemView.findViewById(R.id.iv_settings)
        var tv_settings: TextView = itemView.findViewById(R.id.tv_settings)
        var lv_settings: LinearLayout = itemView.findViewById(R.id.lv_settings)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrendingListViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.row_settings, parent, false)
        return TrendingListViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return settingsListItem.size
    }

    override fun onBindViewHolder(holder: TrendingListViewHolder, position: Int) {
        holder.iv_settings.setImageResource(settingsListItem.get(position).settingIcon)
        holder.tv_settings.setText(settingsListItem.get(position).settingTitle)

        holder.lv_settings.setOnClickListener {

            if (settingsListItem[position].settingTitle=="Share App") {
                val appPackageName = context.packageName // Get the package name
                val shareIntent = Intent(Intent.ACTION_SEND).apply {
                    type = "text/plain"
                    putExtra(Intent.EXTRA_TEXT, "Check out this app: https://play.google.com/store/apps/details?id=$appPackageName")
                }

                context.startActivity(Intent.createChooser(shareIntent, "Share app via"))
            } else if(settingsListItem[position].settingTitle=="Rate Us") {
                val appPackageName = context.packageName // Get the package name of your app
                try {
                    // Try to open the Play Store app
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=$appPackageName"))
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                    context.startActivity(intent)
                } catch (e: ActivityNotFoundException) {
                    // If the Play Store app is not available, open in the web browser
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=$appPackageName"))
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                    context.startActivity(intent)
                }
            } else if(settingsListItem[position].settingTitle=="Privacy Policy") {

                val intent = Intent(context, PrivacyPolicyActivity::class.java)
                context.startActivity(intent)

            }

        }

    }

}