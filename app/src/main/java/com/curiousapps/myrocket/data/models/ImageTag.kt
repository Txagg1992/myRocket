package com.curiousapps.myrocket.data.models


import com.google.gson.annotations.SerializedName

data class ImageTag(
    @SerializedName("api_detail_url")
    var apiDetailUrl: String,
    @SerializedName("name")
    var name: String,
    @SerializedName("total")
    var total: Int
)