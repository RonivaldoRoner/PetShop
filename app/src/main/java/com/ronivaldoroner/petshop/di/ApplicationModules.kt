package com.ronivaldoroner.petshop.di

import com.ronivaldoroner.petshop.remote.di.remoteModule

val applicationModules = listOf(
    presentationModules,
    remoteModule
).flatten()