package com.ronivaldoroner.petshop.domain.features.marketplace

import com.ronivaldoroner.petshop.domain.helpers.ErrorInformation
import com.ronivaldoroner.petshop.domain.helpers.Response

interface ProductsProvider {
    suspend fun getProducts(): Response<MarketPlaceScreen, ErrorInformation>
}