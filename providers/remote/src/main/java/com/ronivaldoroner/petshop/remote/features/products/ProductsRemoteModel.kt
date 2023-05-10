package com.ronivaldoroner.petshop.remote.features.products


import com.google.gson.annotations.SerializedName
import com.ronivaldoroner.petshop.domain.features.products.ProductsModel
import java.io.Serializable

data class ProductsRemoteModel(
    @SerializedName("productList")
    val products: List<ProductRemoteModel>
) : Serializable

fun ProductsRemoteModel.toDomain() = ProductsModel(
    products = this.products.map { it.toDomain() }
)
