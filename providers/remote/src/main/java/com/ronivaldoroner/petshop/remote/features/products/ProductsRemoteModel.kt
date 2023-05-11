package com.ronivaldoroner.petshop.remote.features.products


import com.google.gson.annotations.SerializedName
import com.ronivaldoroner.petshop.domain.features.marketplace.MarketPlaceScreen
import java.io.Serializable

data class ProductsRemoteModel(
    @SerializedName("productList")
    val products: List<ProductRemoteModel>
) : Serializable

fun ProductsRemoteModel.toDomain() = MarketPlaceScreen(
    products = this.products.map { it.toDomain() }
)
