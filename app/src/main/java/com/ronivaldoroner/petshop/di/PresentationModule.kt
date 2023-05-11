package com.ronivaldoroner.petshop.di

import com.ronivaldoroner.petshop.features.marketplace.marketPlaceKoinModule
import org.koin.core.module.Module

val presentationModules = listOf<Module>(
    marketPlaceKoinModule
)