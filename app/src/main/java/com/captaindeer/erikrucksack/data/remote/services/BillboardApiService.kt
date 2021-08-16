package com.captaindeer.erikrucksack.data.remote.services

import com.captaindeer.erikrucksack.data.remote.responses.BillboardResponse
import com.captaindeer.erikrucksack.data.remote.responses.BillboardSearchResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface BillboardApiService {

    @GET(value = "v3/top/anime/1")
    suspend fun getTopAnime(): Response<BillboardResponse>

    @GET
    suspend fun getByName(@Url url: String): Response<BillboardSearchResponse>

}
