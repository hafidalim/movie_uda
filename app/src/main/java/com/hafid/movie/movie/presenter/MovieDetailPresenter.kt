package com.hafid.movie.movie.presenter

import android.content.Context
import com.hafid.movie.favorite.database.MovieDB

import com.hafid.movie.movie.data.ResultsItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MovieDetailPresenter(var context: Context) {
    private val db = MovieDB.getDatabase(context)
    val view : OptionsFavoriteView = context as OptionsFavoriteView

    fun addFavorite(movieDB: ResultsItem){
        db.movieDao().insertMovie(movieDB)
        view.onFavorited()
    }

    fun removiewFavorite(movieDB: ResultsItem){
        db.movieDao().delete(movieDB)
        view.onUnFavorited()
    }

    @Suppress("SENSELESS_COMPARISON")
    fun isFavorite(movie: ResultsItem) : Boolean{
        return db.movieDao().getId(movie.id) != null
    }
    fun getFavoriteMovie(){

            val data = db.movieDao().all
            if (data.isNotEmpty()){
                view.onFavorited()
            }

    }
}

interface OptionsFavoriteView {
    fun onFavorited()
    fun onUnFavorited()
    fun loadMovie(data: List<ResultsItem>)
}
