package com.hafid.movie.profile


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.hafid.movie.R
import com.hafid.movie.utils.SessionManager
import kotlinx.android.synthetic.main.fragment_profile.*
import kotlinx.coroutines.newSingleThreadContext

/**
 * A simple [Fragment] subclass.
 */
class ProfileFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_profile, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val sessionManager = context?.let { SessionManager(it) }
        tvProfileNama.text = sessionManager?.nama
        tvProfileEmail.text = sessionManager?.email
        tvProfileHp.text = sessionManager?.phone
    }


}
