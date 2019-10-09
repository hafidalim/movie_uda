package com.hafid.movie.favorite


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

/**
 * A simple [Fragment] subclass.
 */
class FavoriteFragment : Fragment(){



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favorite, container, false)


    }


}

