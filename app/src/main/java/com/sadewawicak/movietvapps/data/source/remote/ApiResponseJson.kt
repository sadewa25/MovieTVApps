package com.sadewawicak.movietvapps.data.source.remote

class ApiResponseJson <T>(val status: StatusResponse, val body: T?, val message: String?) {
    companion object {
        fun <T> success(body: T?): ApiResponseJson<T> {
            return ApiResponseJson(
                StatusResponse.SUCCESS,
                body,
                null
            )
        }

        fun <T> empty(msg: String, body: T?): ApiResponseJson<T> {
            return ApiResponseJson(
                StatusResponse.EMPTY,
                body,
                msg
            )
        }

        fun <T> error(msg: String, body: T?): ApiResponseJson<T> {
            return ApiResponseJson(
                StatusResponse.ERROR,
                body,
                msg
            )
        }
    }
}