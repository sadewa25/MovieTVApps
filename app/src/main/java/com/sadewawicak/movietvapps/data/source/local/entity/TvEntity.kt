package com.sadewawicak.movietvapps.data.source.local.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "tv")
data class TvEntity
    (
    @SerializedName("original_name")
    @ColumnInfo(name = "title_tvs") var titleTvs: String,

    @SerializedName("vote_average")
    @ColumnInfo(name = "rating") var rating: String,

    @SerializedName("first_air_date")
    @ColumnInfo(name = "date") var date: String,

    @SerializedName("poster_path")
    @ColumnInfo(name = "poster_path") var posterPath: String,

    @SerializedName("overview")
    @ColumnInfo(name = "overview") var overview: String,


    @ColumnInfo(name = "isBookmarked") var isBookmarked: Boolean = false,

    @SerializedName("id")
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") var id: Long = 0
) : Parcelable