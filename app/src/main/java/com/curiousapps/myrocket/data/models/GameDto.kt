package com.curiousapps.myrocket.data.models


import com.google.gson.annotations.SerializedName

data class GameDto(
    @SerializedName("error")
    var error: String,
    @SerializedName("limit")
    var limit: Int,
    @SerializedName("number_of_page_results")
    var numberOfPageResults: Int,
    @SerializedName("number_of_total_results")
    var numberOfTotalResults: Int,
    @SerializedName("offset")
    var offset: Int,
    @SerializedName("results")
    var results: List<Results>,
    @SerializedName("status_code")
    var statusCode: Int,
    @SerializedName("version")
    var version: String
)