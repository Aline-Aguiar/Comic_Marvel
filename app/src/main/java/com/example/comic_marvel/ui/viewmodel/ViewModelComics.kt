package com.example.comic_marvel.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.comic_marvel.model.ui.ComicsUi
import com.example.comic_marvel.model.ui.toComics
import com.example.comic_marvel.repository.RepositoryApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.net.UnknownHostException

class ViewModelComics : ViewModel() {

    private val _listMutableComics = MutableLiveData<List<ComicsUi>>()
    val listMutableComics: LiveData<List<ComicsUi>> = _listMutableComics

    val loading = MutableLiveData<Boolean>()
    val errorMessage = MutableLiveData<String>()
    private val repository = RepositoryApi()

    fun getAllComics() = CoroutineScope(Dispatchers.IO).launch {
        loading.postValue(true)
        try {
            repository.getComicsService().let { comicsResponse ->
                val comics = comicsResponse.data.results.map {
                    it.toComics()
                }
                _listMutableComics.postValue(comics)
                loading.postValue(false)
            }
        } catch (error: Throwable) {
            loading.postValue(false)
            handleError(error)
        }

    }

    private fun handleError(error: Throwable) {
        when (error) {
            is HttpException -> errorMessage.postValue("Erro de conexão código: ${error.code()}")
            is UnknownHostException -> errorMessage.postValue("Verifique sua conexão")
        }
    }
}