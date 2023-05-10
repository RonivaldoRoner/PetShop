package com.ronivaldoroner.petshop.remote.services

import com.ronivaldoroner.petshop.remote.constants.Route
import com.ronivaldoroner.petshop.remote.features.products.ProductsRemoteModel
import retrofit2.http.GET

interface ProductsService {
    @GET(Route.GET_PRODUCTS)
    suspend fun getProducts() : ProductsRemoteModel
}