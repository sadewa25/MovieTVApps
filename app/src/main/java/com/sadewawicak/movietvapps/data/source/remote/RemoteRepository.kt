package com.sadewawicak.movietvapps.data.source.remote

import com.sadewawicak.movietvapps.data.source.local.entity.MovieEntity
import com.sadewawicak.movietvapps.data.source.local.entity.TvEntity
import com.sadewawicak.movietvapps.data.source.remote.response.MovieResponses
import com.sadewawicak.movietvapps.data.source.remote.response.TvResponse
import com.sadewawicak.movietvapps.utils.EspressoIdlingResources
import retrofit2.await

open class RemoteRepository(private val apiService: RetrofitClient){
    companion object {
        private var INSTANCE: RemoteRepository? = null

        fun getInstance(apiService: RetrofitClient): RemoteRepository {
            if (INSTANCE == null) {
                INSTANCE = RemoteRepository(apiService)
            }
            return INSTANCE as RemoteRepository
        }
    }

    suspend fun getAllMoviesLiveData(): ApiResponseJson<MovieResponses> {
        EspressoIdlingResources().increment()
        val result = ApiResponseJson.success(apiService.response().doGetMovie().await())
        if(!EspressoIdlingResources().getEspressoIdlingResource()?.isIdleNow!!){
            EspressoIdlingResources().decrement()
        }
        return result
    }

    suspend fun getAllTvsLiveData():ApiResponseJson<TvResponse>{
        EspressoIdlingResources().increment()
        val result = ApiResponseJson.success(apiService.response().doGetTv().await())
        if(!EspressoIdlingResources().getEspressoIdlingResource()?.isIdleNow!!){
            EspressoIdlingResources().decrement()
        }
        return result
    }

    suspend fun getMovieById(id:String): ApiResponseJson<MovieEntity> {
        EspressoIdlingResources().increment()
        val result = ApiResponseJson.success(apiService.response().doGetDetailMovies(id).await())
        if(!EspressoIdlingResources().getEspressoIdlingResource()?.isIdleNow!!){
            EspressoIdlingResources().decrement()
        }
        return result
    }

    suspend fun getTvById(id:String): ApiResponseJson<TvEntity> {
        EspressoIdlingResources().increment()
        val result = ApiResponseJson.success(apiService.response().doGetDetailTvs(id).await())
        if(!EspressoIdlingResources().getEspressoIdlingResource()?.isIdleNow!!){
            EspressoIdlingResources().decrement()
        }
        return result
    }

}