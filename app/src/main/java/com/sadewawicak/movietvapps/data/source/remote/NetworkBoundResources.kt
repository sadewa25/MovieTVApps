package com.sadewawicak.movietvapps.data.source.remote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.sadewawicak.movietvapps.utils.ContextProvider
import com.sadewawicak.movietvapps.vo.Resources
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

abstract class NetworkBoundResource<ResultType, RequestType>constructor(private val contextProviders: ContextProvider) {
    private val result = MediatorLiveData<Resources<ResultType>>()
    private fun onFetchFailed() {}
    protected abstract fun loadFromDB(): LiveData<ResultType>
    protected abstract fun shouldFetch(data: ResultType): Boolean?
    protected abstract fun createCall(): LiveData<ApiResponseJson<RequestType>>?
    protected abstract fun saveCallResult(data: RequestType?)

    init {
        result.value = Resources.loading(null)
        val dbSource = loadFromDB()
        result.addSource(dbSource) { data ->
            result.removeSource(dbSource)
            if (shouldFetch(data)!!) {
                fetchFromNetwork(dbSource)
            } else {
                result.addSource(dbSource) { newData ->
                    result.setValue(Resources.success(newData))
                }
            }
        }
    }

    private fun fetchFromNetwork(dbSource: LiveData<ResultType>) {
        val apiResponse = createCall()
        apiResponse?.let {
            result.addSource(dbSource) { newData ->
                result.setValue(Resources.loading(newData))
            }
            result.addSource(it) { response ->
                result.removeSource(it)
                result.removeSource(dbSource)
                when (response.status) {
                    StatusResponse.SUCCESS -> {
                        GlobalScope.launch(contextProviders.IO){
                            saveCallResult(response.body)
                            GlobalScope.launch(contextProviders.Main){
                                result.addSource(loadFromDB()) { newData ->
                                    result.setValue(Resources.success(newData))
                                }
                            }
                        }
                    }
                    StatusResponse.EMPTY -> {
                        GlobalScope.launch(contextProviders.Main){
                            result.addSource(loadFromDB()) { newData ->
                                result.setValue(Resources.success(newData))
                            }
                        }
                    }
                    StatusResponse.ERROR -> {
                        onFetchFailed()
                        result.addSource(dbSource) { newData ->
                            response.message?.let { message ->
                                result.setValue(Resources.error(message, newData))
                            }
                        }
                    }
                }
            }
        }
    }

    fun asLiveData(): LiveData<Resources<ResultType>> {
        return result
    }
}