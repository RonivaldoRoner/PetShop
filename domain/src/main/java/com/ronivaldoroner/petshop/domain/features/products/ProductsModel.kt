package com.ronivaldoroner.petshop.domain.features.products

import java.io.Serializable

data class ProductsModel(
    val amount: String,
    val description: String,
    val id: Int,
    val imageUrl: String,
    val quantity: Int,
    val weight: String
) : Serializable