package com.sadewawicak.movietvapps.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*
import com.sadewawicak.movietvapps.data.source.local.entity.MovieEntity
import com.sadewawicak.movietvapps.data.source.remote.response.ResultsItemMovieResponse

@Dao
interface MovieDao {

    /*INSERT*/
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovies(movies: List<MovieEntity>): LongArray

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovie(movie: MovieEntity): Long

    /*QUERY*/
    @Query("SELECT * FROM movie WHERE isBookmarked = 1")
    fun getBookmarkedMoviePaged(): DataSource.Factory<Int,MovieEntity>

    @Query("SELECT * FROM movie WHERE id = :movieid")
    fun getMovieId(movieid: String): LiveData<MovieEntity>

    @Query("SELECT * FROM movie")
    fun getAllMovies(): LiveData<List<MovieEntity>>

    /*UPDATE*/
    @Update
    fun updateMovie(movie: MovieEntity): Int
}
