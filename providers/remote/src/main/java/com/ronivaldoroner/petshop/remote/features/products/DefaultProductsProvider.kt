package com.ronivaldoroner.petshop.remote.features.products

import com.ronivaldoroner.petshop.domain.features.marketplace.MarketPlaceScreen
import com.ronivaldoroner.petshop.domain.features.marketplace.ProductsProvider
import com.ronivaldoroner.petshop.domain.helpers.ErrorInformation
import com.ronivaldoroner.petshop.domain.helpers.Response
import com.ronivaldoroner.petshop.domain.helpers.toErrorInformation
import com.ronivaldoroner.petshop.remote.services.ProductsService

class DefaultProductsProvider(
    private val service: ProductsService
) : ProductsProvider {
    override suspend fun getProducts(): Response<MarketPlaceScreen, ErrorInformation> = runCatching {
        val result = service.getProducts()
        Response.Success(result.toDomain())
    }.getOrElse {
        Response.Error(it.toErrorInformation())
    }
}
