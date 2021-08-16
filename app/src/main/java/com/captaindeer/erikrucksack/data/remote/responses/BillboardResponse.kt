package com.captaindeer.erikrucksack.data.remote.responses

import com.google.gson.annotations.SerializedName

data class BillboardResponse(
    @SerializedName("request_hash") val request_hash: String,
    @SerializedName("request_cached") val request_cached: Boolean,
    @SerializedName("request_cache_expiry") val request_cache_expiry: Int,
    @SerializedName("top") val top: MutableList<ItemBillboardResponse>
)