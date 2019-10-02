package com.hafid.movie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.hafid.movie.movie.data.ResultsItem
import com.hafid.movie.movie.presenter.MoviePresenter
import com.hafid.movie.movie.presenter.MovieView
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.activity_detail.img_poster
import kotlinx.android.synthetic.main.content_detail_layout.*
import kotlinx.android.synthetic.main.item_movie.*

class DetailActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)


        val intentt = intent.getSerializableExtra("movie") as ResultsItem
        Glide.with(this).load("https://image.tmdb.org/t/p/w185/"+intentt.backdropPath).into(img_banner)
        Glide.with(this).load("https://image.tmdb.org/t/p/w185/"+intentt.posterPath).into(img_poster)

        tv_title_detail.text = intentt.originalTitle
        tv_overview.text = intentt.overview
        tvReleaseDate.text = intentt.releaseDate



    }

}
