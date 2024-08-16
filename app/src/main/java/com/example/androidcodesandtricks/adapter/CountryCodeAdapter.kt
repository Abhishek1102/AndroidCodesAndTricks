package com.example.androidcodesandtricks.adapter

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.androidcodesandtricks.R
import com.example.androidcodesandtricks.model.CountryCode


class CountryCodeAdapter(private val context: Context, private val countryList: List<CountryCode>): RecyclerView.Adapter<CountryCodeAdapter.CountryCodeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryCodeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_country_code, parent, false)
        return CountryCodeViewHolder(view)
    }

    override fun onBindViewHolder(holder: CountryCodeViewHolder, position: Int) {
        val countryCode = countryList[position]
        holder.tv_country.setText(countryCode.country)
        holder.tv_code.setText(countryCode.code)
        holder.tv_flag.setText(countryCode.flag)

        holder.itemView.setOnClickListener {

            openDialPad(countryCode.code)

        }

    }

    override fun getItemCount(): Int = countryList.size

    class CountryCodeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tv_country: TextView = itemView.findViewById(R.id.tv_countryName)
        var tv_code: TextView = itemView.findViewById(R.id.tv_countryCode)
        var tv_flag: TextView = itemView.findViewById(R.id.tv_countryFlag)
    }

    private fun openDialPad(code: String) {
        val intent = Intent(Intent.ACTION_DIAL)
        intent.setData(Uri.parse("tel:${code}"))
        context.startActivity(intent)
    }

}