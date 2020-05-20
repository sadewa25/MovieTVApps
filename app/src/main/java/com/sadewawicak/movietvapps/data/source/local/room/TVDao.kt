package com.sadewawicak.movietvapps.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*
import com.sadewawicak.movietvapps.data.source.local.entity.TvEntity

@Dao
interface TVDao{

    /*INSERT*/
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTvs(tvShows: List<TvEntity>): LongArray

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTv(tvShow: TvEntity): Long

    /*UPDATE*/
    @Update
    fun updateTvShow(tvShow: TvEntity): Int

    /*QUERY*/
    @Query("SELECT * FROM tv WHERE isBookmarked = 1")
    fun getBookmarkedTvPaged(): DataSource.Factory<Int,TvEntity>

    @Query("SELECT * FROM tv")
    fun getAllTvs(): LiveData<List<TvEntity>>

    @Query("SELECT * FROM tv WHERE id = :id")
    fun getTvById(id: String): LiveData<TvEntity>

}