package com.ronivaldoroner.petshop.remote.di

import com.ronivaldoroner.petshop.domain.features.marketplace.ProductsProvider
import com.ronivaldoroner.petshop.remote.features.products.DefaultProductsProvider
import org.koin.dsl.module

val providerKoinModule = module {
    factory <ProductsProvider>{
        DefaultProductsProvider(
            service = get()
        )
    }
}