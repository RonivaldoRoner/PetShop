package com.ronivaldoroner.petshop.domain.features.products

import com.ronivaldoroner.petshop.domain.helpers.Response

interface ProductsProvider {
    suspend fun getProducts(): Response<ProductsModel, Throwable>
}