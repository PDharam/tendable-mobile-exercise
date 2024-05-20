package com.pdharam.tendable.network

sealed class ApiResult<out R> {
    data class Success<out T>(val data: T) : ApiResult<T>()
    data class Error(val error: Exception) : ApiResult<Nothing>()
}