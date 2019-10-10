package com.hafid.movie.favorite


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.hafid.movie.R
import com.hafid.movie.movie.adapter.MovieAdapter
import com.hafid.movie.movie.data.ResultsItem
import com.hafid.movie.movie.presenter.MoviePresenter
import com.hafid.movie.movie.presenter.MovieView
import kotlinx.android.synthetic.main.fragment_favorite.*

/**
 * A simple [Fragment] subclass.
 */
class FavoriteFragment : Fragment(), MovieView{
    private lateinit var presenter: MoviePresenter
    private lateinit var adapter: MovieAdapter
    private var data: List<ResultsItem?>? = null


    override fun onSuccessMovie(data: List<ResultsItem?>?) {
        rv_movies.adapter = MovieAdapter(data)

    }

    override fun onErrorMovie(msg: String?) {

    }

    override fun onResume() {
        super.onResume()
        context?.let { presenter.getFavoriteMovie(it) }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favorite, container, false)

        rv_movies.adapter = adapter
        context?.let { presenter.getMovieFavoriteList(it) }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = MoviePresenter(this)
        context?.let { presenter.getFavoriteMovie(it) }
    }


}

