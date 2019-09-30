package com.hafid.movie.login.presenter

import com.hafid.movie.login.data.ResultLogin
import com.hafid.movie.network.NetworkConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.math.log

class LoginPresenter(val loginView: LoginView) {

    fun login(email : String, password: String){
        if (email.isEmpty()){
            loginView.onErrorLogin("Tidak boleh kosong")
            return

        }
        else if (password.isEmpty()){
            loginView.onErrorLogin("Tidak boleh kosong")
        }

        NetworkConfig.service()
            .login(email, password)
            .enqueue(object : Callback<ResultLogin>{
                override fun onFailure(call: Call<ResultLogin>, t: Throwable) {
                    loginView.onErrorLogin(t.localizedMessage)
                }

                override fun onResponse(call: Call<ResultLogin>, response: Response<ResultLogin>) {
                    if (response.body()?.status == 200){
                        loginView.onSuccessLogin(response.body()?.user, response.body()?.message)
                    } else{
                        loginView.onErrorLogin(response?.body()?.message)
                    }
                }
            })


    }
}