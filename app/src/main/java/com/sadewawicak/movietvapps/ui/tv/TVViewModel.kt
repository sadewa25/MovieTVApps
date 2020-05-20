package com.sadewawicak.movietvapps.ui.tv

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.sadewawicak.movietvapps.data.source.AppRepository
import com.sadewawicak.movietvapps.data.source.local.entity.TvEntity
import com.sadewawicak.movietvapps.data.source.remote.response.ResponseJSON
import com.sadewawicak.movietvapps.vo.Resources

class TVViewModel(val mAcademyRepository: AppRepository?) : ViewModel() {

    fun getTVShows(): LiveData<Resources<List<TvEntity>>>? {
        return mAcademyRepository?.getTv()
    }

}