package com.curiousapps.myrocket.data.models


import com.google.gson.annotations.SerializedName

data class Image(
    @SerializedName("icon_url")
    var iconUrl: String,
    @SerializedName("image_tags")
    var imageTags: String,
    @SerializedName("medium_url")
    var mediumUrl: String,
    @SerializedName("original_url")
    var originalUrl: String,
    @SerializedName("screen_large_url")
    var screenLargeUrl: String,
    @SerializedName("screen_url")
    var screenUrl: String,
    @SerializedName("small_url")
    var smallUrl: String,
    @SerializedName("super_url")
    var superUrl: String,
    @SerializedName("thumb_url")
    var thumbUrl: String,
    @SerializedName("tiny_url")
    var tinyUrl: String
){
    companion object{
        var imageUrl =
            Image(
                smallUrl = "",
                iconUrl = "",
                mediumUrl = "",
                imageTags = "",
                originalUrl = "",
                screenUrl = "",
                screenLargeUrl = "",
                superUrl = "",
                thumbUrl = "",
                tinyUrl = ""
            )
    }
}

//Image(
//smallUrl = smallUrl,
//iconUrl = iconUrl,
//mediumUrl = mediumUrl,
//imageTags = imageTags,
//originalUrl = originalUrl,
//screenUrl = screenUrl,
//screenLargeUrl = screenLargeUrl,
//superUrl = superUrl,
//thumbUrl = thumbUrl,
//tinyUrl = tinyUrl
//)