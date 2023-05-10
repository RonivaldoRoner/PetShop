package com.ronivaldoroner.petshop.domain.base

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel

interface CommandAction<T> {

    suspend fun onPreCommand(
        currentState: T,
        effect: Channel<Any>,
        dispatcher: Dispatchers
    ): T = currentState

    suspend fun onCommand(
        currentState: T,
        effect: Channel<Any>,
        dispatcher: Dispatchers
    ): T

    suspend fun onPosCommand(
        currentState: T,
        effect: Channel<Any>,
        dispatcher: Dispatchers
    ): T = currentState
}