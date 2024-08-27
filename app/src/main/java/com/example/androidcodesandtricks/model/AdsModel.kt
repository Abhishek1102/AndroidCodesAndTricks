package com.example.androidcodesandtricks.model

data class AdsModel(
    var id: String = "",
    var banner_g: String = "",
    var interstitial_g: String = "",
    var appOpen_g: String = "",
    var ad_status: Boolean = false,
    var interstitial_ad_click_counter: String = ""
) {
    // Secondary no-argument constructor
    constructor() : this("", "", "", "", false, "")
}

