package com.captaindeer.erikrucksack.data.remote.responses

import com.google.gson.annotations.SerializedName

data class ItemBillboardResponse(
    @SerializedName("title") val title: String,
    @SerializedName("url") val url: String,
    @SerializedName("image_url") val image_url: String,
    @SerializedName("episodes") val episodes: Int,
    @SerializedName("score") val score: Float
)