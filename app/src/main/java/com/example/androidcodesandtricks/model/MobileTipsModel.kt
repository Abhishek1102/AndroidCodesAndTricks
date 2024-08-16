package com.example.androidcodesandtricks.model

//make secretCodesItemTitle optional like nullable if no value is provided

data class MobileTipsModel(
    var mobileTipsItemImage: Int,
    var mobileTipsItemTitle: String? = null
)
