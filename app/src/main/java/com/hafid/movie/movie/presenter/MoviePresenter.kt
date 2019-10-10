package com.hafid.movie.movie.presenter


import android.content.Context
import com.hafid.movie.favorite.database.MovieDB
import com.hafid.movie.movie.data.ResultMovie
import com.hafid.movie.movie.data.ResultsItem
import com.hafid.movie.network.NetworkConfig
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MoviePresenter(val homeView: MovieView) {

    fun movie(){
        NetworkConfig.serviceMovie()
            .getMovie("052a0efe01d590db2b8e3aac840d8a92","en-US")
            .enqueue(object : Callback<ResultMovie>{
                override fun onFailure(call: Call<ResultMovie>, t: Throwable) {

                }

                override fun onResponse(call: Call<ResultMovie>, response: Response<ResultMovie>) {
                    if (response.isSuccessful){
                        homeView.onSuccessMovie(response.body()?.results)
                    }

                }
            })
    }

    fun getMovieFavoriteList(context: Context) : List<ResultsItem>{
        val movie = MovieDB
        return movie.getDatabase(context).movieDao().all

    }
    fun getFavoriteMovie(context: Context){
        val database = MovieDB
            val data = database.getDatabase(context).movieDao().all
            if (data.isNotEmpty()){
                homeView.onSuccessMovie(data)
            }


    }

}