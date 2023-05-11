package com.ronivaldoroner.petshop.domain.features.marketplace

import com.ronivaldoroner.petshop.domain.helpers.ResourceStatus
import java.io.Serializable


data class MarketPlaceScreen(
    val status: ResourceStatus = ResourceStatus.Loading,
    val products : List<ProductModel> = listOf()
): Serializable
data class ProductModel(
    val amount: String,
    val description: String,
    val id: Int,
    val imageUrl: String,
    val quantity: Int,
    val weight: String
) : Serializable