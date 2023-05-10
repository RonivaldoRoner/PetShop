package com.ronivaldoroner.petshop.domain.base

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlin.coroutines.cancellation.CancellationException

class ScreenStore<T : Any>(
    initialState: T,
    private val dispatchers: Dispatchers,
) {

    private val _state: MutableStateFlow<T> = MutableStateFlow(initialState)
    val state: StateFlow<T> get() = _state

    private val _effect: Channel<Any> = Channel()
    val effect = _effect.receiveAsFlow()

    suspend fun execute(command: CommandAction<T>) {
        updateState(command::onPreCommand)
        updateState(command::onCommand)
        updateState(command::onPosCommand)
    }

    private suspend fun updateState(
        command: suspend (T, Channel<Any>, Dispatchers) -> T
    ) = runCatching {
        val previousState = state.value
        _state.value = command(previousState, _effect, dispatchers)
    }.getOrElse {
        when (it) {
            is CancellationException -> Unit
            else -> {
                //TODO
                //Log error here
            }
        }
    }


}