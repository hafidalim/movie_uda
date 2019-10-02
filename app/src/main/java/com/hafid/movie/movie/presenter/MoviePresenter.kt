package com.hafid.movie.movie.presenter

import com.hafid.movie.movie.data.ResultMovie
import com.hafid.movie.network.NetworkConfig
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
}