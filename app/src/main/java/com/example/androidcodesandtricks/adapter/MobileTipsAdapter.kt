package com.example.androidcodesandtricks.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.androidcodesandtricks.R
import com.example.androidcodesandtricks.model.MobileTipsModel
import com.example.androidcodesandtricks.model.SecretCodesModel

class MobileTipsAdapter(
    private val context: Context,
    private val mobileTipsList: ArrayList<MobileTipsModel>,
) : RecyclerView.Adapter<MobileTipsAdapter.MobileTipsListViewHolder>() {

    class MobileTipsListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var iv_mobileTipsListItem: ImageView = itemView.findViewById(R.id.iv_trendingItem)
        var tv_mobileTipsListItem: TextView = itemView.findViewById(R.id.tv_trendingItem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MobileTipsListViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.row_trending_list, parent, false)
        return MobileTipsListViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return mobileTipsList.size
    }

    override fun onBindViewHolder(holder: MobileTipsListViewHolder, position: Int) {
        holder.iv_mobileTipsListItem.setImageResource(mobileTipsList.get(position).mobileTipsItemImage)
        holder.tv_mobileTipsListItem.setText(mobileTipsList.get(position).mobileTipsItemTitle)

        holder.itemView.setOnClickListener {

            Toast.makeText(context, "Clicked ${mobileTipsList.get(position).mobileTipsItemTitle}", Toast.LENGTH_SHORT).show()
            
        }

    }

}