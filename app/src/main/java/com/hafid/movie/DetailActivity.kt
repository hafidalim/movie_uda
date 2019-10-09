package com.hafid.movie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide

import com.hafid.movie.movie.data.ResultsItem

import com.hafid.movie.movie.presenter.MovieDetailPresenter
import com.hafid.movie.movie.presenter.MoviePresenter
import com.hafid.movie.movie.presenter.MovieView
import com.hafid.movie.movie.presenter.OptionsFavoriteView
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.activity_detail.img_poster
import kotlinx.android.synthetic.main.content_detail_layout.*
import kotlinx.android.synthetic.main.item_movie.*

class DetailActivity : AppCompatActivity(), OptionsFavoriteView {
    override fun loadMovie(data: List<ResultsItem>) {

    }

    private lateinit var movie: ResultsItem
    private lateinit var movieDetailPresenter: MovieDetailPresenter
    private var menuItem: Menu?= null

    override fun onFavorited() {
        favorite()
        Log.d("Berhasil","disimpan")


    }

    override fun onUnFavorited() {
        favorite()
        Log.d("Berhasil", "dihapus")
        progress_bar.visibility = View.GONE
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)


        movie = intent.getParcelableExtra("movie") as ResultsItem
        Glide.with(this).load("https://image.tmdb.org/t/p/w185/"+movie.backdropPath).into(img_banner)
        Glide.with(this).load("https://image.tmdb.org/t/p/w185/"+movie.posterPath).into(img_poster)

        tv_title_detail.text = movie.originalTitle
        tv_overview.text = movie.overview
        tvReleaseDate.text = movie.releaseDate

        movieDetailPresenter = MovieDetailPresenter(this)
        favorite()
        progress_bar.visibility = View.GONE



    }

    private fun favorite() {
        if(movieDetailPresenter.isFavorite(movie))
        {
            menuItem?.getItem(0)?.icon = ContextCompat.getDrawable(this, R.drawable.ic_favorite_white_24dp)

        } else{
            menuItem?.getItem(0)?.icon = ContextCompat.getDrawable(this, R.drawable.ic_favorite_border_black_24dp)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_favorite, menu)
        menuItem = menu
        favorite()
        return super.onCreateOptionsMenu(menu)


    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
    return when(item.itemId){

        R.id.add_to_favorite->{
            if (movieDetailPresenter.isFavorite(movie))
                movieDetailPresenter.removiewFavorite(movie)
            else
                movieDetailPresenter.addFavorite(movie)
            favorite()
            return true
        }
        else->super.onOptionsItemSelected(item)
    }
    }



}
