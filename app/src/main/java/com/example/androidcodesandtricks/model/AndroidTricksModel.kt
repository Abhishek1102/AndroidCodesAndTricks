package com.example.androidcodesandtricks.model

//make secretCodesItemTitle optional like nullable if no value is provided

data class AndroidTricksModel(
    var androidTricksItemImage: Int,
    var androidTricksItemTitle: String? = null
)
