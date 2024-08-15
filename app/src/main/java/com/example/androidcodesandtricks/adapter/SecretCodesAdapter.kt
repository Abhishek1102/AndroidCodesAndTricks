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
import com.example.androidcodesandtricks.model.SecretCodesModel

class SecretCodesAdapter(
    private val context: Context,
    private val secretCodesList: ArrayList<SecretCodesModel>,
) : RecyclerView.Adapter<SecretCodesAdapter.SecretCodesListViewHolder>() {

    class SecretCodesListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var iv_secretCodesListItem: ImageView = itemView.findViewById(R.id.iv_trendingItem)
        var tv_secretCodesListItem: TextView = itemView.findViewById(R.id.tv_trendingItem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SecretCodesListViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.row_trending_list, parent, false)
        return SecretCodesListViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return secretCodesList.size
    }

    override fun onBindViewHolder(holder: SecretCodesListViewHolder, position: Int) {
        holder.iv_secretCodesListItem.setImageResource(secretCodesList.get(position).secretCodesItemImage)
        holder.tv_secretCodesListItem.setText(secretCodesList.get(position).secretCodesItemTitle)

        holder.itemView.setOnClickListener {

            Toast.makeText(context, "Clicked ${secretCodesList.get(position).secretCodesItemTitle}", Toast.LENGTH_SHORT).show()
            
        }

    }

}