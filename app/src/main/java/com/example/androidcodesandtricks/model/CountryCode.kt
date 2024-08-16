package com.example.androidcodesandtricks.model

import android.content.Context
import org.json.JSONArray
import java.io.IOException

data class CountryCode(val country: String, val code: String, val flag: String)

fun loadCountryData(context: Context): List<CountryCode> {
    try {
        val jsonFile = context.assets.open("CountryCodeData.json").bufferedReader().use { it.readText() }
        val jsonArray = JSONArray(jsonFile)
        val countryList = mutableListOf<CountryCode>()

        for (i in 0 until jsonArray.length()) {
            val jsonObject = jsonArray.getJSONObject(i)
            val country = jsonObject.getString("country")
            val code = jsonObject.getString("code")
            val flag = jsonObject.getString("flag")
            countryList.add(CountryCode(country, code, flag))
        }

        return countryList
    } catch (e: IOException) {
        e.printStackTrace()
        return emptyList()
    }
}
