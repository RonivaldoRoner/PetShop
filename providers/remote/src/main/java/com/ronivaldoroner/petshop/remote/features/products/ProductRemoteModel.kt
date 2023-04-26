package com.ronivaldoroner.petshop.remote.features.products


import com.google.gson.annotations.SerializedName

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
)