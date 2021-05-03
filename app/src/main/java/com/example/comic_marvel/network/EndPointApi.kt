package com.example.comic_marvel.network

import com.example.comic_marvel.model.ComicsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface EndPointApi {

    @GET("/v1/public/comics")
    suspend fun getResponseComics(
        @Query("limit") limit: Int?,
        @Query("offset") offset: Int?,
//        @Query("orderBy") orderBy: String?,
        @Query("ts") ts: String,
        @Query("apikey") apikey: String?,
        @Query("hash") hash: String?): ComicsResponse
}