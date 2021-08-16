package com.captaindeer.erikrucksack.data.remote

import com.captaindeer.erikrucksack.data.remote.responses.BillboardResponse
import com.captaindeer.erikrucksack.data.remote.responses.BillboardSearchResponse
import com.captaindeer.erikrucksack.data.remote.services.BillboardApiService
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitBuilder {

    private val client = OkHttpClient.Builder().build()
    private lateinit var billboardApiService: BillboardApiService

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.jikan.moe/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()


    suspend fun getTopAnime(): Response<BillboardResponse> {
        billboardApiService = retrofit.create(BillboardApiService::class.java)
        return billboardApiService.getTopAnime()
    }

    suspend fun getByName(title: String): Response<BillboardSearchResponse> {
        billboardApiService = retrofit.create(BillboardApiService::class.java)
        return billboardApiService.getByName("v3/search/anime?q=$title&page=1")
    }
}