package com.sadewawicak.movietvapps.data.source.local

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import com.sadewawicak.movietvapps.data.source.local.entity.MovieEntity
import com.sadewawicak.movietvapps.data.source.local.entity.TvEntity
import com.sadewawicak.movietvapps.data.source.local.room.MovieDao
import com.sadewawicak.movietvapps.data.source.local.room.TVDao

open class LocalRepository(private val mMovieDao: MovieDao, private val mTvShowDao: TVDao) {

    companion object {
        private var INSTANCE: LocalRepository? = null
        fun getInstance(mMovieDao: MovieDao, mTvShowDao: TVDao): LocalRepository {
            if (INSTANCE == null) {
                INSTANCE = LocalRepository(mMovieDao, mTvShowDao)
            }
            return INSTANCE as LocalRepository
        }
    }

    /*************************************Movie************************************/
    /*****************************************************************************/
    fun insertMovies(movies: List<MovieEntity>) {
        mMovieDao.insertMovies(movies)
    }

    fun insertMovie(movie: MovieEntity) {
        mMovieDao.insertMovie(movie)
    }

    fun getAllMovies(): LiveData<List<MovieEntity>> {
        return mMovieDao.getAllMovies()
    }

    fun getMovieByMovieId(movieid: String): LiveData<MovieEntity> {
        return mMovieDao.getMovieId(movieid)
    }

    fun getBookmarkMoviePaged(): DataSource.Factory<Int, MovieEntity> {
        return mMovieDao.getBookmarkedMoviePaged()
    }

    fun setMovieBookmark(movie: MovieEntity, flag: Boolean) {
        movie.isBookmarked = flag
        mMovieDao.updateMovie(movie)
    }

    /*************************************TV************************************/
    /*************************************************************************/
    fun insertTvs(tvShows: List<TvEntity>) {
        mTvShowDao.insertTvs(tvShows)
    }

    fun insertTv(tvShow: TvEntity) {
        mTvShowDao.insertTv(tvShow)
    }

    fun getAllTvs(): LiveData<List<TvEntity>> {
        return mTvShowDao.getAllTvs()
    }

    fun getTvById(id: String): LiveData<TvEntity> {
        return mTvShowDao.getTvById(id)
    }

    fun getBookmarkTv(): DataSource.Factory<Int, TvEntity> {
        return mTvShowDao.getBookmarkedTvPaged()
    }

    fun setTvBookmark(tvShow: TvEntity, flag: Boolean) {
        tvShow.isBookmarked = flag
        mTvShowDao.updateTvShow(tvShow)
    }

}