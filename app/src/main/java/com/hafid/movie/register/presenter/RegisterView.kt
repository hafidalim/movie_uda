package com.hafid.movie.register.presenter

interface RegisterView {
    fun onSuccessRegister(msg : String?)
    fun onErrorResgister(msg : String?)
}