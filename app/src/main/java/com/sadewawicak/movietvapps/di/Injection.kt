package com.sadewawicak.movietvapps.di

import android.app.Application
import com.sadewawicak.movietvapps.data.source.AppRepository
import com.sadewawicak.movietvapps.data.source.remote.RemoteRepository
import com.sadewawicak.movietvapps.data.source.local.LocalRepository
import com.sadewawicak.movietvapps.data.source.local.MovieTVDatabase
import com.sadewawicak.movietvapps.data.source.remote.RetrofitClient

class Injection {
    companion object{
        fun provideRepository(application: Application?): AppRepository? {
            val database: MovieTVDatabase? = MovieTVDatabase.getInstance(application!!)
            val localRepository = database?.movieDao()?.let { mDao ->
                LocalRepository(mDao,database.tvDao())
            }
            val remoteRepository = RemoteRepository.getInstance(RetrofitClient())
            return localRepository?.let { localrepo ->
                AppRepository.getInstance(remoteRepository,localrepo)
            }
        }
    }
}