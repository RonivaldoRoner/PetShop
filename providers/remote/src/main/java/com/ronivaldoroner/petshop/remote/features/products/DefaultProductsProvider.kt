package com.ronivaldoroner.petshop.remote.features.products

import com.ronivaldoroner.petshop.domain.features.products.ProductsModel
import com.ronivaldoroner.petshop.domain.features.products.ProductsProvider
import com.ronivaldoroner.petshop.domain.helpers.Response

class DefaultProductsProvider : ProductsProvider {

    override suspend fun getProducts(): Response<List<ProductsModel>, Throwable> {
        TODO("Not yet implemented")
    }

}