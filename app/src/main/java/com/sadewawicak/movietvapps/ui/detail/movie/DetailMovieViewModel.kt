package com.sadewawicak.movietvapps.ui.detail.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.sadewawicak.movietvapps.data.source.AppRepository

class DetailMovieViewModel(private val mAcademyRepository: AppRepository?) : ViewModel() {

    private var idMovies = MutableLiveData<String>()

    var movieEntity = Transformations.switchMap(idMovies) { movieId ->
        mAcademyRepository?.getMovieById(movieId)
    }

    fun setIDMovies(idMovies: String?) {
        this.idMovies.value = idMovies
    }

    fun setMovieBookmark() {
        if (movieEntity.value != null) {
            val movie = movieEntity.value?.data
            movie.let { m ->
                val newState = !m?.isBookmarked!!
                mAcademyRepository?.setMovieBookmark(m, newState)
            }
        }
    }

}