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
import com.example.androidcodesandtricks.model.AndroidTricksModel
import com.example.androidcodesandtricks.model.MobileTipsModel
import com.example.androidcodesandtricks.model.SecretCodesModel

class AndroidTricksAdapter(
    private val context: Context,
    private val androidTricksList: ArrayList<AndroidTricksModel>,
) : RecyclerView.Adapter<AndroidTricksAdapter.AndroidTricksListViewHolder>() {

    class AndroidTricksListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var iv_androidTricksListItem: ImageView = itemView.findViewById(R.id.iv_trendingItem)
        var tv_androidTricksListItem: TextView = itemView.findViewById(R.id.tv_trendingItem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AndroidTricksListViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.row_trending_list, parent, false)
        return AndroidTricksListViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return androidTricksList.size
    }

    override fun onBindViewHolder(holder: AndroidTricksListViewHolder, position: Int) {
        holder.iv_androidTricksListItem.setImageResource(androidTricksList.get(position).androidTricksItemImage)
        holder.tv_androidTricksListItem.setText(androidTricksList.get(position).androidTricksItemTitle)

        holder.itemView.setOnClickListener {

            Toast.makeText(context, "Clicked ${androidTricksList.get(position).androidTricksItemTitle}", Toast.LENGTH_SHORT).show()
            
        }

    }

}