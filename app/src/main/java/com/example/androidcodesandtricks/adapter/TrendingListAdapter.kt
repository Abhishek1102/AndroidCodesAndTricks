package com.example.androidcodesandtricks.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.androidcodesandtricks.R
import com.example.androidcodesandtricks.activity.MobileTipsDetailActivity
import com.example.androidcodesandtricks.activity.SecretCodesDetailActivity
import com.example.androidcodesandtricks.model.TrendingListModel

class TrendingListAdapter(
    private val context: Context,
    private val trendingItemList: ArrayList<TrendingListModel>,
) : RecyclerView.Adapter<TrendingListAdapter.TrendingListViewHolder>() {


    class TrendingListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var iv_trendingListItem: ImageView = itemView.findViewById(R.id.iv_trendingItem)
        var tv_trendingListItem: TextView = itemView.findViewById(R.id.tv_trendingItem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrendingListViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.row_trending_list, parent, false)
        return TrendingListViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return trendingItemList.size
    }

    override fun onBindViewHolder(holder: TrendingListViewHolder, position: Int) {
        holder.iv_trendingListItem.setImageResource(trendingItemList.get(position).trendingItemImage)
        holder.tv_trendingListItem.setText(trendingItemList.get(position).trendingItemTitle)

        holder.itemView.setOnClickListener {

            if(trendingItemList.get(position).trendingItemTitle=="Samsung") {
                // Create an Intent to start SecretCodesDetailActivity
                val intent = Intent(context, SecretCodesDetailActivity::class.java)
                intent.putExtra("SECRET_CODE_TITLE", "Samsung")
                context.startActivity(intent)
            } else if(trendingItemList.get(position).trendingItemTitle=="Manage Android") {
                // Create an Intent to start MobileTipsDetailActivity
                val intent = Intent(context, MobileTipsDetailActivity::class.java)
                intent.putExtra("MOBILE_TIPS_TITLE", "Manage Android")
                context.startActivity(intent)
            } else if(trendingItemList.get(position).trendingItemTitle=="Vivo") {
                // Create an Intent to start SecretCodesDetailActivity
                val intent = Intent(context, SecretCodesDetailActivity::class.java)
                intent.putExtra("SECRET_CODE_TITLE", "Vivo")
                context.startActivity(intent)
            } else if(trendingItemList.get(position).trendingItemTitle=="Add Owner Info") {
                // Create an Intent to start MobileTipsDetailActivity
                val intent = Intent(context, MobileTipsDetailActivity::class.java)
                intent.putExtra("MOBILE_TIPS_TITLE", "Add Owner Info")
                context.startActivity(intent)
            } else if(trendingItemList.get(position).trendingItemTitle=="LG") {
                // Create an Intent to start SecretCodesDetailActivity
                val intent = Intent(context, SecretCodesDetailActivity::class.java)
                intent.putExtra("SECRET_CODE_TITLE", "LG")
                context.startActivity(intent)
            } else if(trendingItemList.get(position).trendingItemTitle=="Manage Memory") {
                // Create an Intent to start MobileTipsDetailActivity
                val intent = Intent(context, MobileTipsDetailActivity::class.java)
                intent.putExtra("MOBILE_TIPS_TITLE", "Manage Memory")
                context.startActivity(intent)
            } else if(trendingItemList.get(position).trendingItemTitle=="Google") {
                // Create an Intent to start SecretCodesDetailActivity
                val intent = Intent(context, SecretCodesDetailActivity::class.java)
                intent.putExtra("SECRET_CODE_TITLE", "Google")
                context.startActivity(intent)
            } else if(trendingItemList.get(position).trendingItemTitle=="Wifi Password") {
                // Create an Intent to start MobileTipsDetailActivity
                val intent = Intent(context, MobileTipsDetailActivity::class.java)
                intent.putExtra("MOBILE_TIPS_TITLE", "Wifi Password")
                context.startActivity(intent)
            } else if(trendingItemList.get(position).trendingItemTitle=="Speed up Android") {
                // Create an Intent to start MobileTipsDetailActivity
                val intent = Intent(context, MobileTipsDetailActivity::class.java)
                intent.putExtra("MOBILE_TIPS_TITLE", "Speed up Android")
                context.startActivity(intent)
            }  else if(trendingItemList.get(position).trendingItemTitle=="MI") {
                // Create an Intent to start SecretCodesDetailActivity
                val intent = Intent(context, SecretCodesDetailActivity::class.java)
                intent.putExtra("SECRET_CODE_TITLE", "MI")
                context.startActivity(intent)
            } else if(trendingItemList.get(position).trendingItemTitle=="Unknown Facts") {
                // Create an Intent to start MobileTipsDetailActivity
                val intent = Intent(context, MobileTipsDetailActivity::class.java)
                intent.putExtra("MOBILE_TIPS_TITLE", "Unknown Facts")
                context.startActivity(intent)
            } else if(trendingItemList.get(position).trendingItemTitle=="Huawei") {
                // Create an Intent to start SecretCodesDetailActivity
                val intent = Intent(context, SecretCodesDetailActivity::class.java)
                intent.putExtra("SECRET_CODE_TITLE", "Huawei")
                context.startActivity(intent)
            } else if(trendingItemList.get(position).trendingItemTitle=="Recover Files") {
                // Create an Intent to start MobileTipsDetailActivity
                val intent = Intent(context, MobileTipsDetailActivity::class.java)
                intent.putExtra("MOBILE_TIPS_TITLE", "Recover Files")
                context.startActivity(intent)
            } else if(trendingItemList.get(position).trendingItemTitle=="Oppo") {
                // Create an Intent to start SecretCodesDetailActivity
                val intent = Intent(context, SecretCodesDetailActivity::class.java)
                intent.putExtra("SECRET_CODE_TITLE", "Oppo")
                context.startActivity(intent)
            }  else if(trendingItemList.get(position).trendingItemTitle=="Break Pattern") {
                // Create an Intent to start MobileTipsDetailActivity
                val intent = Intent(context, MobileTipsDetailActivity::class.java)
                intent.putExtra("MOBILE_TIPS_TITLE", "Break Pattern")
                context.startActivity(intent)
            }   else if(trendingItemList.get(position).trendingItemTitle=="Tecno Facts") {
                // Create an Intent to start SecretCodesDetailActivity
                val intent = Intent(context, SecretCodesDetailActivity::class.java)
                intent.putExtra("SECRET_CODE_TITLE", "Tecno Facts")
                context.startActivity(intent)
            }    else if(trendingItemList.get(position).trendingItemTitle=="Unlock Pattern") {
                // Create an Intent to start MobileTipsDetailActivity
                val intent = Intent(context, MobileTipsDetailActivity::class.java)
                intent.putExtra("MOBILE_TIPS_TITLE", "Unlock Pattern")
                context.startActivity(intent)
            }

        }

    }

}