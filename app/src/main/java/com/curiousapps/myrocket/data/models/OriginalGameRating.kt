package com.curiousapps.myrocket.data.models


import com.google.gson.annotations.SerializedName

data class OriginalGameRating(
    @SerializedName("api_detail_url")
    var apiDetailUrl: String,
    @SerializedName("id")
    var id: Int,
    @SerializedName("name")
    var name: String
)