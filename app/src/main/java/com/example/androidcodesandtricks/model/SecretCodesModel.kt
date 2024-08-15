package com.example.androidcodesandtricks.model

//make secretCodesItemTitle optional like nullable if no value is provided

data class SecretCodesModel(
    var secretCodesItemImage: Int,
    var secretCodesItemTitle: String? = null
)
