package com.ronivaldoroner.petshop.domain.helpers

import java.io.Serializable

sealed class Response<out T, out E> : Serializable {
    open class Success<out T>(
        val response: T
    ) : Response<T, Nothing>()

    open class ErrorResponse<out E>(
        val error: ErrorInformation,
    ) : Response<Nothing, E>()
}

