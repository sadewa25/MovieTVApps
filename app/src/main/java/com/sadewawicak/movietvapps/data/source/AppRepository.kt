package com.sadewawicak.movietvapps.data.source

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.sadewawicak.movietvapps.data.source.local.LocalRepository
import com.sadewawicak.movietvapps.data.source.local.entity.MovieEntity
import com.sadewawicak.movietvapps.data.source.local.entity.TvEntity
import com.sadewawicak.movietvapps.data.source.remote.ApiResponseJson
import com.sadewawicak.movietvapps.data.source.remote.NetworkBoundResource
import com.sadewawicak.movietvapps.data.source.remote.RemoteRepository
import com.sadewawicak.movietvapps.data.source.remote.response.MovieResponses
import com.sadewawicak.movietvapps.data.source.remote.response.TvResponse
import com.sadewawicak.movietvapps.utils.ContextProvider
import com.sadewawicak.movietvapps.vo.Resources
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

open class AppRepository(
    private val remoteRepository: RemoteRepository,
    private val localRepository: LocalRepository?,
    private val coroutineContext: ContextProvider
) : AppDataSource {

    companion object {
        @Volatile
        private var INSTANCE: AppRepository? = null

        fun getInstance(
            remoteRepository: RemoteRepository,
            localRepository: LocalRepository?
        ): AppRepository = INSTANCE
            ?: synchronized(AppRepository::class.java) {
                AppRepository(
                    remoteRepository,
                    localRepository,
                    ContextProvider.getInstance()
                ).also {
                    INSTANCE = it
                }
            }
    }

    /////////////////////////////////MOVIE/////////////////////////////////////////
    override fun getMovie(): LiveData<Resources<List<MovieEntity>>> {
        val data =
            object : NetworkBoundResource<List<MovieEntity>, MovieResponses>(coroutineContext) {
                override fun loadFromDB(): LiveData<List<MovieEntity>> {
                    return localRepository!!.getAllMovies()
                }

                override fun shouldFetch(data: List<MovieEntity>): Boolean? {
                    return data.isEmpty()
                }

                override fun createCall(): LiveData<ApiResponseJson<MovieResponses>>? {
                    val data = MutableLiveData<ApiResponseJson<MovieResponses>>()
                    GlobalScope.launch(Dispatchers.IO) {
                        val result = remoteRepository.getAllMoviesLiveData()
                        data.postValue(result)
                    }
                    return data
                }

                override fun saveCallResult(data: MovieResponses?) {
                    data?.results?.let { movies ->
                        localRepository?.insertMovies(movies)
                    }
                }
            }.asLiveData()
        return data
    }

    override fun getMovieById(id: String): LiveData<Resources<MovieEntity>> {
        val data =
            object : NetworkBoundResource<MovieEntity, MovieEntity>(coroutineContext) {
                override fun loadFromDB(): LiveData<MovieEntity> {
                    return localRepository!!.getMovieByMovieId(id)
                }

                override fun shouldFetch(data: MovieEntity): Boolean? {
                    return false
                }

                override fun createCall(): LiveData<ApiResponseJson<MovieEntity>>? {
                    val data = MutableLiveData<ApiResponseJson<MovieEntity>>()
                    GlobalScope.launch(Dispatchers.IO) {
                        val result = remoteRepository.getMovieById(id)
                        data.postValue(result)
                    }
                    return data
                }

                override fun saveCallResult(data: MovieEntity?) {
                    data?.let { movies ->
                        localRepository?.insertMovie(movies)
                    }
                }
            }.asLiveData()
        return data
    }

    override fun getBookmarkMovie(): LiveData<Resources<PagedList<MovieEntity>>> {
        val data = object : NetworkBoundResource<PagedList<MovieEntity>,MovieResponses>(coroutineContext){
            override fun loadFromDB(): LiveData<PagedList<MovieEntity>> {
                return LivePagedListBuilder(localRepository?.getBookmarkMoviePaged() as DataSource.Factory<Int, MovieEntity>,10).build()
            }

            override fun shouldFetch(data: PagedList<MovieEntity>): Boolean? {
                return false
            }

            override fun createCall(): LiveData<ApiResponseJson<MovieResponses>>? {
                return null
            }

            override fun saveCallResult(data: MovieResponses?) {}

        }.asLiveData()
        return data
    }

    /////////////////////////////////END MOVIE/////////////////////////////////////////
    /////////////////////////////////TV///////////////////////////////////////////////
    override fun getTv(): LiveData<Resources<List<TvEntity>>> {
        val data = object : NetworkBoundResource<List<TvEntity>, TvResponse>(coroutineContext) {
            override fun loadFromDB(): LiveData<List<TvEntity>> {
                return localRepository!!.getAllTvs()
            }

            override fun shouldFetch(data: List<TvEntity>): Boolean? {
                return data.isEmpty()
            }

            override fun createCall(): LiveData<ApiResponseJson<TvResponse>>? {
                val data = MutableLiveData<ApiResponseJson<TvResponse>>()
                GlobalScope.launch(Dispatchers.IO) {
                    val result = remoteRepository.getAllTvsLiveData()
                    data.postValue(result)
                }
                return data
            }

            override fun saveCallResult(data: TvResponse?) {
                data?.results?.let { movies ->
                    localRepository?.insertTvs(movies)
                }
            }
        }.asLiveData()
        return data
    }

    override fun getTvById(id: String): LiveData<Resources<TvEntity>> {
        val data =
            object : NetworkBoundResource<TvEntity, TvEntity>(coroutineContext) {
                override fun loadFromDB(): LiveData<TvEntity> {
                    return localRepository!!.getTvById(id)
                }

                override fun shouldFetch(data: TvEntity): Boolean? {
                    return false
                }

                override fun createCall(): LiveData<ApiResponseJson<TvEntity>>? {
                    val data = MutableLiveData<ApiResponseJson<TvEntity>>()
                    GlobalScope.launch(Dispatchers.IO) {
                        val result = remoteRepository.getTvById(id)
                        data.postValue(result)
                    }
                    return data
                }

                override fun saveCallResult(data: TvEntity?) {
                    data?.let { movies ->
                        localRepository?.insertTv(movies)
                    }
                }
            }.asLiveData()
        return data
    }

    override fun setMovieBookmark(movie: MovieEntity, flag: Boolean) {
        GlobalScope.launch(Dispatchers.IO) {
            localRepository?.setMovieBookmark(movie, flag)
        }
    }

    override fun setTvBookmark(tv: TvEntity, flag: Boolean) {
        GlobalScope.launch(Dispatchers.IO) {
            localRepository?.setTvBookmark(tv, flag)
        }
    }

    override fun getBookmarkTv(): LiveData<Resources<PagedList<TvEntity>>> {
        val data = object : NetworkBoundResource<PagedList<TvEntity>,TvResponse>(coroutineContext){
            override fun loadFromDB(): LiveData<PagedList<TvEntity>> {
                return LivePagedListBuilder(localRepository?.getBookmarkTv() as DataSource.Factory<Int, TvEntity>,10).build()
            }

            override fun shouldFetch(data: PagedList<TvEntity>): Boolean? {
                return false
            }

            override fun createCall(): LiveData<ApiResponseJson<TvResponse>>? {
                return null
            }

            override fun saveCallResult(data: TvResponse?) {}

        }.asLiveData()
        return data
    }
    /////////////////////////////////End TV////////////////////////////////////////////

}