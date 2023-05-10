package com.ronivaldoroner.petshop.domain.helpers

import java.io.Serializable

sealed class ResourceStatus : Serializable {

    object Ready: ResourceStatus()

    object Loading: ResourceStatus()

    data class Error(val errorInformation: ErrorInformation? = null) : ResourceStatus()

    val isReady get() = this is Ready

    val isLoading get() = this is Loading

    val isError get() = this is Error
}