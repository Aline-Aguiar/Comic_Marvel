package com.example.comic_marvel.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import com.example.comic_marvel.R
import com.example.comic_marvel.ui.adapter.ComicsAdapter
import com.example.comic_marvel.ui.viewmodel.ViewModelComics

class MainActivity : AppCompatActivity() {

    private val recycler by lazy { findViewById<RecyclerView>(R.id.recycler_main) }
    val viewModelComics by lazy { ViewModelProviders.of(this).get(ViewModelComics::class.java)}
    private val progressBar by lazy { findViewById<ProgressBar>(R.id.progressBar) }
    private val comicsAdapter by lazy { ComicsAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recycler?.adapter = comicsAdapter
        observeEvents()
        viewModelComics.getAllComics()
    }

    private fun observeEvents() {
        viewModelComics.listMutableComics.observe(this, {
            it?.let {comics ->
            comicsAdapter.comicsList = comics}
        })
        viewModelComics.loading.observe(this, {
            if (it){
                progressBar.visibility = View.VISIBLE
            }else{
                progressBar.visibility = View.GONE
            }
        })
        viewModelComics.errorMessage.observe(this,{
            it?.let {
                Toast.makeText(this,it,Toast.LENGTH_LONG).show()
            }
        })
    }
}