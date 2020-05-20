package com.sadewawicak.movietvapps.data.source.remote

import com.sadewawicak.movietvapps.data.source.local.entity.MovieEntity
import com.sadewawicak.movietvapps.data.source.local.entity.TvEntity
import com.sadewawicak.movietvapps.data.source.remote.response.MovieResponses
import com.sadewawicak.movietvapps.data.source.remote.response.ResponseJSON
import com.sadewawicak.movietvapps.data.source.remote.response.TvResponse
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface API {

    @GET("movie/popular?api_key=ff38f4d494b3c4f76d37a64fec7828d5&language=en-US&page=1")
    fun doGetMovie(): Call<MovieResponses>

    @GET("tv/popular?api_key=ff38f4d494b3c4f76d37a64fec7828d5&language=en-US&page=1")
    fun doGetTv(): Call<TvResponse>

    @GET("movie/{id}?api_key=ff38f4d494b3c4f76d37a64fec7828d5&language=en-US")
    fun doGetDetailMovies(
        @Path("id") id: String
    ): Deferred<MovieEntity>

    @GET("tv/{id}?api_key=ff38f4d494b3c4f76d37a64fec7828d5&language=en-US")
    fun doGetDetailTvs(
        @Path("id") id: String
    ): Deferred<TvEntity>

}