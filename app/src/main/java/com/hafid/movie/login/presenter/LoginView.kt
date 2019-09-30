package com.hafid.movie.login.presenter

import com.hafid.movie.login.data.User

interface LoginView {
    fun onSuccessLogin(user: User?, msg: String?)
    fun onErrorLogin(msg: String?)
}