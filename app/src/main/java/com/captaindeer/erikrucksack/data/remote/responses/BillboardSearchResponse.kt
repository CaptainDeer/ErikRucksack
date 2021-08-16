package com.captaindeer.erikrucksack.data.remote.responses

import com.google.gson.annotations.SerializedName

data class BillboardSearchResponse(
    @SerializedName("request_hash") val request_hash: String,
    @SerializedName("request_cached") val request_cached: Boolean,
    @SerializedName("request_cache_expiry") val request_cache_expiry: Int,
    @SerializedName("results") val results: MutableList<ItemBillboardResponse>
)