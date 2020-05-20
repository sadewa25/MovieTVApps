package com.sadewawicak.movietvapps.ui.bookmark.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.sadewawicak.movietvapps.data.source.AppRepository
import com.sadewawicak.movietvapps.data.source.local.entity.MovieEntity
import com.sadewawicak.movietvapps.vo.Resources

class BookmarkMovieViewModel(val mAcademyRepository: AppRepository?) : ViewModel() {

    fun getBookmarkMovie(): LiveData<Resources<PagedList<MovieEntity>>>? {
        return mAcademyRepository?.getBookmarkMovie()
    }

}