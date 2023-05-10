package com.ronivaldoroner.petshop.remote.di

import com.ronivaldoroner.petshop.remote.base.NetworkAdapter
import com.ronivaldoroner.petshop.remote.services.ProductsService
import org.koin.dsl.module

val networkKoinModule = module {
    single { NetworkAdapter.createWebService(ProductsService::class.java) }
}