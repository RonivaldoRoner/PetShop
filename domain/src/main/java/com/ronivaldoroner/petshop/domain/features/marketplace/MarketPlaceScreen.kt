package com.ronivaldoroner.petshop.domain.features.marketplace

import java.io.Serializable


data class MarketPlaceModel(
    val products : List<ProductModel>
): Serializable
data class ProductModel(
    val amount: String,
    val description: String,
    val id: Int,
    val imageUrl: String,
    val quantity: Int,
    val weight: String
) : Serializable