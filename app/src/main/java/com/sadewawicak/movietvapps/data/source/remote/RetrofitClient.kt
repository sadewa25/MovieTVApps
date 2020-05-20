package com.sadewawicak.movietvapps.data.source.remote

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitClient {

    val url = "https://api.themoviedb.org/3/"
    val urlImages = "https://image.tmdb.org/t/p/w500/"

    companion object{
        val ok = OkHttpClient.Builder()
            .connectTimeout(50000, TimeUnit.SECONDS)
            .writeTimeout(50000, TimeUnit.SECONDS)
            .readTimeout(50000, TimeUnit.SECONDS)
            .build()
    }

    fun response(): API {
        val client = Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .client(ok)
            .build()
        return client.create(API::class.java)
    }

}