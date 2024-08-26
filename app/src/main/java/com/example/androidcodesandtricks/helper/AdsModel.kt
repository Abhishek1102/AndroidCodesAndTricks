package com.example.androidcodesandtricks.helper

data class AdsModel(
    var id: String = "",
    var banner_g: String = "",
    var interstitial_g: String = "",
    var appOpen_g: String = "",
    var ad_status: Boolean = false
) {
    // Secondary no-argument constructor
    constructor() : this("", "", "", "", false)
}
