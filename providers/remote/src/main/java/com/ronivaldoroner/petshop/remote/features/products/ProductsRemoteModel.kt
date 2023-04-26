package com.ronivaldoroner.petshop.remote.features.products


import com.google.gson.annotations.SerializedName

data class ProductsRemoteModel(
    @SerializedName("productList")
    val products: List<ProductRemoteModel>
)