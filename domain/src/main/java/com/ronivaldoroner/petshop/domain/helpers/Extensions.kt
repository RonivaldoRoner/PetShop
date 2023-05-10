package com.ronivaldoroner.petshop.domain.helpers

fun Throwable.toErrorInformation() = ErrorInformation(
    code = null,
    message = this.message.orEmpty()
)