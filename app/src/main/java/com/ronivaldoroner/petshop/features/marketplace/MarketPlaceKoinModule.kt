package com.ronivaldoroner.petshop.features.marketplace

import androidx.lifecycle.SavedStateHandle
import com.ronivaldoroner.petshop.domain.base.CommandAction
import com.ronivaldoroner.petshop.domain.base.ScreenStore
import com.ronivaldoroner.petshop.domain.features.marketplace.MarketPlaceAction
import com.ronivaldoroner.petshop.domain.features.marketplace.MarketPlaceScreen
import com.ronivaldoroner.petshop.features.marketplace.MarketPlaceViewModel.Companion.MARKET_PLACE_STATE
import kotlinx.coroutines.Dispatchers
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val marketPlaceKoinModule = module {

    factory<CommandAction<MarketPlaceScreen>>{
        MarketPlaceAction(
            provider = get()
        )
    }

    viewModel {(savedSate: SavedStateHandle)->
        val screenStore = ScreenStore<MarketPlaceScreen>(
            initialState = savedSate[MARKET_PLACE_STATE]?: MarketPlaceScreen(),
            dispatchers = Dispatchers
        )

        MarketPlaceViewModel(
            savedStateHandle = savedSate,
            screenStore = screenStore
        )
    }
}