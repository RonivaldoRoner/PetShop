package com.ronivaldoroner.petshop.domain.features.marketplace

import com.ronivaldoroner.petshop.domain.base.CommandAction
import com.ronivaldoroner.petshop.domain.helpers.ResourceStatus
import com.ronivaldoroner.petshop.domain.helpers.Response
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel

class MarketPlaceAction(
    private val provider: ProductsProvider
) : CommandAction<MarketPlaceScreen> {

    override suspend fun onPreCommand(
        currentState: MarketPlaceScreen,
        effect: Channel<Any>,
        dispatcher: Dispatchers
    ): MarketPlaceScreen = currentState.copy(
        status = ResourceStatus.Loading
    )

    override suspend fun onCommand(
        currentState: MarketPlaceScreen,
        effect: Channel<Any>,
        dispatcher: Dispatchers
    ): MarketPlaceScreen = when (val result = provider.getProducts()) {
        is Response.Success -> {
            result.response.copy(
                status = ResourceStatus.Ready
            )
        }

        is Response.Error -> {
            currentState.copy(
                status = ResourceStatus.Error(result.error)
            )
        }
    }
}