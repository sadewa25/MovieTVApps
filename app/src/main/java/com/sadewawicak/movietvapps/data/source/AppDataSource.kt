package com.sadewawicak.movietvapps.data.source

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.sadewawicak.movietvapps.data.source.local.entity.MovieEntity
import com.sadewawicak.movietvapps.data.source.local.entity.TvEntity
import com.sadewawicak.movietvapps.vo.Resources

interface AppDataSource {
    fun getMovie(): LiveData<Resources<List<MovieEntity>>>
    fun getMovieById(id:String): LiveData<Resources<MovieEntity>>
    fun getBookmarkMovie(): LiveData<Resources<PagedList<MovieEntity>>>
    fun setMovieBookmark(movie: MovieEntity, flag: Boolean)

    fun getTv(): LiveData<Resources<List<TvEntity>>>
    fun getTvById(id:String):LiveData<Resources<TvEntity>>
    fun setTvBookmark(tv: TvEntity, flag: Boolean)
    fun getBookmarkTv(): LiveData<Resources<PagedList<TvEntity>>>
}