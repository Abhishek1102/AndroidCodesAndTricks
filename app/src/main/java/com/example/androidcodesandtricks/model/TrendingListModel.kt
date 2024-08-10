package com.example.androidcodesandtricks.model

//make trendingItemTitle optional like nullable if no value is provided

data class TrendingListModel(
    var trendingItemImage: Int,
    var trendingItemTitle: String? = null
)
