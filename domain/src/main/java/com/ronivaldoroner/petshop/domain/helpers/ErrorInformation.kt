package com.ronivaldoroner.petshop.domain.helpers

import java.io.Serializable

data class ErrorInformation(
    val code: Int?,
    val message: String,
) : Serializable