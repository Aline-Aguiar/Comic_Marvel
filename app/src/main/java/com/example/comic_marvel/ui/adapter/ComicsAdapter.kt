package com.example.comic_marvel.ui.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.comic_marvel.R
import com.example.comic_marvel.model.ui.ComicsUi
import com.example.comic_marvel.ui.DetailActivity
import com.squareup.picasso.Picasso

class ComicsAdapter() : RecyclerView.Adapter<ComicsViewHolder>() {

    var comicsList = listOf<ComicsUi>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComicsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.comic_item,
            parent,
            false
        )
        return ComicsViewHolder(view)
    }

    override fun onBindViewHolder(holder: ComicsViewHolder, position: Int) {
        val comics = comicsList[position]
        holder.comicName.text = comics.title
        Picasso.get().load(comics.image?.path + ".jpg").into(holder.comicImage)

        holder.itemView.setOnClickListener {
            val intent = Intent(it.context, DetailActivity::class.java)
            intent.putExtra("COMICS",comics)
            it.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = comicsList.size
}