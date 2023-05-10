package com.ronivaldoroner.petshop.domain.features.products

import java.io.Serializable


data class ProductsModel(
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