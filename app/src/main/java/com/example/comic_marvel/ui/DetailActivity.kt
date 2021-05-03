package com.example.comic_marvel.ui

import android.icu.number.NumberRangeFormatter.with
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.comic_marvel.R
import com.example.comic_marvel.model.ui.ComicsUi
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.squareup.picasso.Picasso

class DetailActivity: AppCompatActivity() {

    val imgHeadDetail by lazy { findViewById<ImageView>(R.id.img_head_detail) }
    val imgComic by lazy { findViewById<ImageView>(R.id.iv_comic_image_details) }
    val txtTitleDetail by lazy { findViewById<TextView>(R.id.tv_detail_title) }
    val txtSumaryDetail by lazy { findViewById<TextView>(R.id.tv_detail_sumary) }
    val txtPublishedDetail by lazy { findViewById<TextView>(R.id.tv_published) }
    val txtPriceDetail by lazy { findViewById<TextView>(R.id.tv_price) }
    val txtPagesDetail by lazy { findViewById<TextView>(R.id.tv_pages) }
    val btArrowDetail by lazy { findViewById<ImageView>(R.id.img_arrow_detail) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val infoDetail = intent.extras

        if (infoDetail != null){
            val comics = infoDetail.getSerializable("COMICS") as ComicsUi
            txtTitleDetail.text = comics.title
            txtSumaryDetail.text = comics.description
//            txtPublishedDetail.text
            txtPriceDetail.text = comics.price.toString()
            txtPagesDetail.text = comics.pageCount.toString()
            Picasso.get().load(comics.image?.path +  ".jpg").into(imgComic)
        }

        btArrowDetail.setOnClickListener {
            onBackPressed()
        }
    }
}