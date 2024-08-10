package com.example.androidcodesandtricks.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.androidcodesandtricks.R
import com.example.androidcodesandtricks.model.AboutDeviceModel

class AboutDeviceAdapter(
    private val context: Context,
    private val aboutDeviceList: ArrayList<AboutDeviceModel>,
) : RecyclerView.Adapter<AboutDeviceAdapter.AboutDeviceListViewHolder>() {


    class AboutDeviceListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tv_aboutDeviceListTitle: TextView = itemView.findViewById(R.id.tv_info_title)
        var tv_aboutDeviceListDesc: TextView = itemView.findViewById(R.id.tv_info_desc)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AboutDeviceListViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.row_about_device, parent, false)
        return AboutDeviceListViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return aboutDeviceList.size
    }

    override fun onBindViewHolder(holder: AboutDeviceListViewHolder, position: Int) {
        holder.tv_aboutDeviceListTitle.setText(aboutDeviceList.get(position).aboutdevice_title)
        holder.tv_aboutDeviceListDesc.setText(aboutDeviceList.get(position).aboutdevice_desc)

        holder.itemView.setOnClickListener {

            Toast.makeText(context, "Clicked ${aboutDeviceList.get(position).aboutdevice_title}", Toast.LENGTH_SHORT).show()
            
        }

    }

}