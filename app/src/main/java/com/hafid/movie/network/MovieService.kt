package com.hafid.movie.network


import com.hafid.movie.login.data.ResultLogin
import com.hafid.movie.register.data.ResultRegister
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface MovieService {

    //login
    @FormUrlEncoded
    @POST("loginUser")
    fun login(
        @Field("email") email : String,
        @Field("password") password : String

    ) : Call<ResultLogin>

    //register
    @FormUrlEncoded
    @POST("registerUser")
    fun register(
        @Field("nama") nama : String,
        @Field("email") email : String,
        @Field("hp") hp : String,
        @Field("password") password : String

    ) : Call<ResultRegister>

}