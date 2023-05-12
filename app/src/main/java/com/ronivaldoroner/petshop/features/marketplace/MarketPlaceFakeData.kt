package com.ronivaldoroner.petshop.features.marketplace

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.ronivaldoroner.petshop.domain.features.marketplace.MarketPlaceScreen
import com.ronivaldoroner.petshop.domain.features.marketplace.ProductModel
import com.ronivaldoroner.petshop.domain.helpers.ErrorInformation
import com.ronivaldoroner.petshop.domain.helpers.ResourceStatus

class MarketPlaceFakeData : PreviewParameterProvider<MarketPlaceScreen> {
    override val values: Sequence<MarketPlaceScreen>
        get() = sequenceOf(
            MarketPlaceScreen(
                status = ResourceStatus.Loading
            ),
            MarketPlaceScreen(
                status = ResourceStatus.Ready,
                products = listOf(
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
            ),
            MarketPlaceScreen(
                status = ResourceStatus.Error(
                    ErrorInformation(
                        code = 500,
                        message = "Falha na internet"
                    )
                )
            )
        )
}