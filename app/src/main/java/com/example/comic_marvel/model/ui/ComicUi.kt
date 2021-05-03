package com.example.comic_marvel.model.ui

import com.example.comic_marvel.model.Price
import com.example.comic_marvel.model.Result
import com.example.comic_marvel.model.Thumbnail
import java.io.Serializable

data class ComicsUi(
    val description: String?,
    val title: String,
    val image: Thumbnail?,
    val price: Price,
    val pageCount: Int?
): Serializable

fun Result.toComics(): ComicsUi {
    return ComicsUi(
        description, title, thumbnail, prices[0], pageCount
    )
}