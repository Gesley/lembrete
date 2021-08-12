package br.com.heiderlopes.lembretedecompras.models

sealed class RequestState<out T> {
    object Loading : RequestState<Nothing>()
    data class Error(val throwable: Throwable) : RequestState<Nothing>()
    data class Success<T>(val data: T): RequestState<T>()
}