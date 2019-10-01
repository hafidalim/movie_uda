package com.hafid.movie.register.presenter

import com.hafid.movie.network.NetworkConfig
import com.hafid.movie.register.data.ResultRegister
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterPresenter(val registerView: RegisterView) {
    fun register(nama: String, email: String, hp: String, password: String) {
        NetworkConfig.service()
            .register(nama, email, hp, password)
            .enqueue(object : Callback<ResultRegister> {
                override fun onFailure(call: Call<ResultRegister>, t: Throwable) {
                    registerView.onErrorResgister(t.localizedMessage)
                }

                override fun onResponse(
                    call: Call<ResultRegister>,
                    response: Response<ResultRegister>
                ) {
                    if(response.body()?.status == 200){
                        registerView.onSuccessRegister(response?.message())
                    }else{
                        registerView.onErrorResgister(response?.message())
                    }
                }
            })
    }
}