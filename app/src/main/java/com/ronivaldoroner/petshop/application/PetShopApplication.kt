package com.ronivaldoroner.petshop.application

import android.app.Application
import com.ronivaldoroner.petshop.di.applicationModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin

class PetShopApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin{
            androidContext(this@PetShopApplication)
            modules(applicationModules)
        }
    }

    override fun onTerminate() {
        super.onTerminate()
        stopKoin()
    }
}