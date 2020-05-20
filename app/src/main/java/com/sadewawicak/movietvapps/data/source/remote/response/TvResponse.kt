package com.sadewawicak.movietvapps.data.source.remote.response

import com.google.gson.annotations.SerializedName
import com.sadewawicak.movietvapps.data.source.local.entity.TvEntity

data class TvResponse(
    @SerializedName("results") val results : List<TvEntity>
)