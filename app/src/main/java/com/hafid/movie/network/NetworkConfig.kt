package com.hafid.movie.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkConfig {
    fun getInterceptor(): OkHttpClient {


        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        return OkHttpClient().newBuilder()
            .addInterceptor(interceptor)
            .build()
    }

    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://192.168.10.193/server_movie/index.php/Api/")
            .client(getInterceptor())

            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun getMovie() : Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/discover/")
            .client(getInterceptor())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun serviceUser() = getRetrofit().create(MovieService::class.java)
    fun serviceMovie() = getMovie().create(MovieService::class.java)
}
