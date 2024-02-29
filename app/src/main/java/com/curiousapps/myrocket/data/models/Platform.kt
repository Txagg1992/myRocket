package com.curiousapps.myrocket.data.models


import com.google.gson.annotations.SerializedName

data class Platform(
    @SerializedName("abbreviation")
    var abbreviation: String,
    @SerializedName("api_detail_url")
    var apiDetailUrl: String,
    @SerializedName("id")
    var id: Int,
    @SerializedName("name")
    var name: String,
    @SerializedName("site_detail_url")
    var siteDetailUrl: String
)