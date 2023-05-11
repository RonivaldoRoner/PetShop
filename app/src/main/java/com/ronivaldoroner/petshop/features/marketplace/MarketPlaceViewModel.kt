package com.ronivaldoroner.petshop.features.marketplace

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ronivaldoroner.petshop.domain.base.CommandAction
import com.ronivaldoroner.petshop.domain.base.ScreenStore
import com.ronivaldoroner.petshop.domain.features.marketplace.MarketPlaceScreen
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.get

class MarketPlaceViewModel(
    private val savedStateHandle: SavedStateHandle,
    private val screenStore: ScreenStore<MarketPlaceScreen>
) : ViewModel(), DefaultLifecycleObserver, KoinComponent {

    val screen get() = screenStore.state

    init {
        screen
            .onStart {
                if(savedStateHandle.contains(MARKET_PLACE_STATE).not()){
                    getData()
                }
            }
            .onEach { savedStateHandle[MARKET_PLACE_STATE] = it }
            .launchIn(viewModelScope)
    }

    fun getData() {
        viewModelScope.launch {
            val commandAction = get<CommandAction<MarketPlaceScreen>>()
            screenStore.execute(commandAction)
        }
    }

    companion object{
        const val MARKET_PLACE_STATE = "MARKET_PLACE_STATE"
    }
}