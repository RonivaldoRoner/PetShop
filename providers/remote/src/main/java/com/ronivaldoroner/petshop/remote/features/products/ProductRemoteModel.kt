package com.ronivaldoroner.petshop.remote.features.products


import com.google.gson.annotations.SerializedName
import com.ronivaldoroner.petshop.domain.features.marketplace.ProductModel
import java.io.Serializable

data class ProductRemoteModel(
    @SerializedName("amount")
    val amount: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("imageUrl")
    val imageUrl: String,
    @SerializedName("quantity")
    val quantity: Int,
    @SerializedName("weight")
    val weight: String
) : Serializable

fun ProductRemoteModel.toDomain() = ProductModel(
    amount = amount,
    description = description,
    id = id,
    imageUrl = imageUrl,
    quantity = quantity,
    weight = weight,
)