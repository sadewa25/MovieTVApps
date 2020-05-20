package com.sadewawicak.movietvapps.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sadewawicak.movietvapps.data.source.AppRepository
import com.sadewawicak.movietvapps.di.Injection
import com.sadewawicak.movietvapps.ui.bookmark.BookmarkViewModel
import com.sadewawicak.movietvapps.ui.bookmark.movie.BookmarkMovieViewModel
import com.sadewawicak.movietvapps.ui.bookmark.tv.BookmarkTvViewModel
import com.sadewawicak.movietvapps.ui.detail.movie.DetailMovieViewModel
import com.sadewawicak.movietvapps.ui.detail.tv.DetailTVViewModel
import com.sadewawicak.movietvapps.ui.movie.MovieViewModel
import com.sadewawicak.movietvapps.ui.tv.TVViewModel

class ViewModelFactory()  : ViewModelProvider.NewInstanceFactory() {

    @Volatile
    private var INSTANCE: ViewModelFactory? = null

    private var mAcademyRepository: AppRepository? = null

    constructor(mAcademyRepository:AppRepository?) : this() {
        this.mAcademyRepository = mAcademyRepository
    }

    fun getInstance(application: Application?): ViewModelFactory? {
        if (INSTANCE == null) {
            synchronized(ViewModelFactory::class.java) {
                INSTANCE = ViewModelFactory(Injection.provideRepository(application))
            }
        }
        return INSTANCE
    }

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MovieViewModel::class.java)) {
            return MovieViewModel(mAcademyRepository) as T
        }
        else if (modelClass.isAssignableFrom(TVViewModel::class.java)){
            return TVViewModel(mAcademyRepository) as T
        }
        else if (modelClass.isAssignableFrom(DetailMovieViewModel::class.java)){
            return DetailMovieViewModel(mAcademyRepository) as T
        }
        else if (modelClass.isAssignableFrom(DetailTVViewModel::class.java)){
            return DetailTVViewModel(mAcademyRepository) as T
        }
        else if (modelClass.isAssignableFrom(BookmarkViewModel::class.java)){
            return BookmarkViewModel() as T
        }
        else if (modelClass.isAssignableFrom(BookmarkMovieViewModel::class.java)){
            return BookmarkMovieViewModel(mAcademyRepository) as T
        }
        else if (modelClass.isAssignableFrom(BookmarkTvViewModel::class.java)){
            return BookmarkTvViewModel(mAcademyRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
    }

}