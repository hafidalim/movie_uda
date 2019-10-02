package com.hafid.movie.movie


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
import kotlinx.android.synthetic.main.fragment_movie.*

/**
 * A simple [Fragment] subclass.
 */
class MovieFragment : Fragment(), MovieView {
    private lateinit var presenter: MoviePresenter



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = MoviePresenter(this)
        presenter.movie()
    }

    override fun onSuccessMovie(data: List<ResultsItem?>?) {
        listMovie.adapter = MovieAdapter(data)
        progressBar.visibility = View.GONE
    }

    override fun onErrorMovie(msg: String?) {

    }


}
