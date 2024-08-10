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

            Toast.makeText(context, "Clicked ${trendingItemList.get(position).trendingItemTitle}", Toast.LENGTH_SHORT).show()
            
        }

    }

}