package com.ronivaldoroner.petshop.helpers

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.LifecycleObserver

@Composable
fun LifecycleDisposable(observer: LifecycleObserver) {
    val owner = LocalLifecycleOwner.current

    DisposableEffect(observer, owner){
        owner.lifecycle.addObserver(observer)

        onDispose {
            owner.lifecycle.removeObserver(observer)
        }
    }
}