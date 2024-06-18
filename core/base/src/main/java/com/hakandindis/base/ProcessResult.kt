package com.hakandindis.base

sealed class ProcessResult<out T : Any> {
    data object Initial : ProcessResult<Nothing>()
    data object Loading : ProcessResult<Nothing>()
    data class Success<out T : Any>(val data: T) : ProcessResult<T>()
    data class Failure(val throwable: Throwable, val message: String = "0000") : ProcessResult<Nothing>()
}