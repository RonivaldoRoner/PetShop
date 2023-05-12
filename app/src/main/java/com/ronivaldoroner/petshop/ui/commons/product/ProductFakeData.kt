package com.ronivaldoroner.petshop.ui.commons.product

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.ronivaldoroner.petshop.domain.features.marketplace.ProductModel

class ProductFakeData : PreviewParameterProvider<ProductModel> {
    override val values: Sequence<ProductModel>
        get() = sequenceOf(
            ProductModel(
                id = 1,
                description = "Escova para pet",
                weight =  "500gr",
                quantity = 1,
                amount = "10,99",
                imageUrl="https://www.petlove.com.br/images/products/231062/product/" +
                        "Escova_Furminator_New_C%C3%A3es_Pelo_Longo_2316474_2_G" +
                        ".jpg?1627741260"
            )
        )
}