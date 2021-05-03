package com.example.comic_marvel.repository

import com.example.comic_marvel.MD5.Companion.md5
import com.example.comic_marvel.model.ComicsResponse
import com.example.comic_marvel.network.EndPointApi
import com.example.comic_marvel.network.RetrofitInit

class RepositoryApi {

    val PUBLIC_KEY: String = "cc23cafdf5f530cab8346131d61b8655"
    val PRIVATE_KEY = "80ce9b136b8f06213882d58e469ee6e68aaf271c"
    val page: Int = 1
    val limit: Int = 60
    //val orderBy: String = "name"
    private val url = "https://gateway.marvel.com"
    val ts = java.lang.Long.toString(System.currentTimeMillis() / 1000)
    val hash = md5(ts + PRIVATE_KEY + PUBLIC_KEY)

    private var service = EndPointApi::class

    private var serviceComic = RetrofitInit(url).create(service)

    suspend fun getComicsService(): ComicsResponse = serviceComic.getResponseComics(
        limit, page, ts, PUBLIC_KEY, hash
    )
}