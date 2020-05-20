package com.sadewawicak.movietvapps.ui.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.sadewawicak.movietvapps.data.source.AppRepository
import com.sadewawicak.movietvapps.data.source.local.entity.MovieEntity
import com.sadewawicak.movietvapps.vo.Resources

class MovieViewModel(val mAcademyRepository: AppRepository?) : ViewModel() {

    fun getMovies(): LiveData<Resources<List<MovieEntity>>>? {
        return mAcademyRepository?.getMovie()
    }

}