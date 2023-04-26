package com.ronivaldoroner.petshop.remote.base

import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.text.DateFormat
import java.util.concurrent.TimeUnit

object NetworkAdapter {

    private const val DEFAULT_TIMEOUT_SECONDS = 30L

    private val client = OkHttpClient.Builder().build()

    fun <T> createWebService(service: Class<T>): T =
        makeRetrofit().create(service)

    private fun makeRetrofit(vararg interceptors: Interceptor): Retrofit =
        Retrofit.Builder()
            .client(makeHttpClient(interceptors))
            .addConverterFactory(GsonConverterFactory.create(makeConverter()))
            .build()

    private fun makeHttpClient(interceptors: Array<out Interceptor>): OkHttpClient =
        client.newBuilder()
            .connectTimeout(DEFAULT_TIMEOUT_SECONDS, TimeUnit.SECONDS)
            .readTimeout(DEFAULT_TIMEOUT_SECONDS, TimeUnit.SECONDS)
            .addInterceptor(headersInterceptor())
            .apply { interceptors().addAll(interceptors) }
            .addInterceptor(loggingInterceptor())
            .build()

    private fun headersInterceptor(): Interceptor =
        Interceptor { chain ->
            chain.proceed(
                chain.request().newBuilder()
                    .addHeader("Accept", "application/json")
                    .addHeader("Accept-Language", "pt-br")
                    .addHeader("Content-Type", "application/json")
                    .build()
            )
        }

    private fun loggingInterceptor(): Interceptor =
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

    private fun makeConverter(): Gson =
        GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .setPrettyPrinting()
            .setDateFormat(DateFormat.FULL)
            .create()

}