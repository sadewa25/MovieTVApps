package com.sadewawicak.movietvapps.ui.detail.tv

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.sadewawicak.movietvapps.data.source.AppRepository

class DetailTVViewModel(private val mAcademyRepository: AppRepository?) :ViewModel() {

    private var idTv = MutableLiveData<String>()

    var tvEntity = Transformations.switchMap(idTv) { tvId ->
        mAcademyRepository?.getTvById(tvId)
    }

    fun setIDTv(idTv: String?) {
        this.idTv.value = idTv
    }

    fun setTvBookmark() {
        if (tvEntity.value != null) {
            val movie = tvEntity.value?.data
            movie.let { m ->
                val newState = !m?.isBookmarked!!
                mAcademyRepository?.setTvBookmark(m, newState)
            }
        }
    }

}