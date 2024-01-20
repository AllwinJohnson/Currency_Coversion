package com.allwin.currencycoversion.data.network


sealed class NetworkResult<T> {
    class Success<T : Any>(val data: T) : NetworkResult<T>()
    class Loading<T> : NetworkResult<T>()
    class Failure<T>(val exception: Throwable) : NetworkResult<T>()
    data class Error<T>(val message: String, val code: Int) : NetworkResult<T>()
}