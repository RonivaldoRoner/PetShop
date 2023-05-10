package com.ronivaldoroner.petshop.remote.features.products

import com.ronivaldoroner.petshop.domain.features.products.ProductsModel
import com.ronivaldoroner.petshop.domain.features.products.ProductsProvider
import com.ronivaldoroner.petshop.domain.helpers.Response
import com.ronivaldoroner.petshop.remote.services.ProductsService

class DefaultProductsProvider(
    private val service: ProductsService
) : ProductsProvider {
    override suspend fun getProducts(): Response<ProductsModel, Throwable> = runCatching {
        val result = service.getProducts()
        Response.Success(result.toDomain())
    }.getOrElse {
        Response.ErrorResponse(it)
    }
}
