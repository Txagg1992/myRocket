package com.curiousapps.myrocket.data.models


import com.google.gson.annotations.SerializedName

data class Results(
    @SerializedName("aliases")
    var aliases: String,
    @SerializedName("api_detail_url")
    var apiDetailUrl: String,
    @SerializedName("date_added")
    var dateAdded: String,
    @SerializedName("date_last_updated")
    var dateLastUpdated: String,
    @SerializedName("deck")
    var deck: String,
    //**
    @SerializedName("description")
    var description: String,
    @SerializedName("expected_release_day")
    var expectedReleaseDay: Any,
    @SerializedName("expected_release_month")
    var expectedReleaseMonth: Any,
    @SerializedName("expected_release_quarter")
    var expectedReleaseQuarter: Int,
    @SerializedName("expected_release_year")
    var expectedReleaseYear: Int,
    @SerializedName("guid")
    var guid: String,
    //**
    @SerializedName("id")
    var id: Int,
    @SerializedName("image")
    var image: Image,

    @SerializedName("image_tags")
    var imageTags: List<ImageTag>,
    //**
    @SerializedName("name")
    var name: String,

    @SerializedName("number_of_user_reviews")
    var numberOfUserReviews: Int,
    @SerializedName("original_game_rating")
    var originalGameRating: List<OriginalGameRating>,
    @SerializedName("original_release_date")
    var originalReleaseDate: String,
    @SerializedName("platforms")
    var platforms: List<Platform>,
    @SerializedName("site_detail_url")
    var siteDetailUrl: String
)