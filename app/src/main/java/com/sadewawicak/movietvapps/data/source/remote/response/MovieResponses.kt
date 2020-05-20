package com.sadewawicak.movietvapps.data.source.remote.response

import com.google.gson.annotations.SerializedName
import com.sadewawicak.movietvapps.data.source.local.entity.MovieEntity

data class MovieResponses(
    @SerializedName("results") val results : List<MovieEntity>
)