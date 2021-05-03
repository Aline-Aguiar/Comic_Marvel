package com.example.comic_marvel.ui.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.comic_marvel.R

class ComicsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val comicName by lazy { view.findViewById<TextView>(R.id.tv_comic_name) }
    val comicImage by lazy { view.findViewById<ImageView>(R.id.iv_comic_image) }
}