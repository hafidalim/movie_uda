package com.hafid.movie.movie.presenter

import com.hafid.movie.movie.data.ResultsItem

interface MovieView {

    fun onSuccessMovie(data : List<ResultsItem?>?)
    fun onErrorMovie(msg : String ?)
}