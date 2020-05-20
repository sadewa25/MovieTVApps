package com.sadewawicak.movietvapps.ui.bookmark.tv

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.sadewawicak.movietvapps.data.source.AppRepository
import com.sadewawicak.movietvapps.data.source.local.entity.TvEntity
import com.sadewawicak.movietvapps.vo.Resources

class BookmarkTvViewModel(val mAcademyRepository: AppRepository?) : ViewModel() {

    fun getBookmarkTv(): LiveData<Resources<PagedList<TvEntity>>>? {
        return mAcademyRepository?.getBookmarkTv()
    }

}