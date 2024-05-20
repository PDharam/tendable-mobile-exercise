package com.pdharam.tendable.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceBuilder {
    //BASE URL
    private val BASE_URL: String = "http://127.0.0.1:5001/api/"

    //CREATE OK HTTP CLIENT
    private val okHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(run {
                val httpLoggingInterceptor = HttpLoggingInterceptor()
                httpLoggingInterceptor.apply {
                    httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
                }
            })
            .build()

    //CREATE RETROFIT BUILDER
    private val retrofitBuilder =
        Retrofit.Builder().baseUrl(BASE_URL).client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())

    //CREATE RETROFIT INSTANCE
    private val retrofit = retrofitBuilder.build()

    fun <T> buildService(service: Class<T>): T = retrofit.create(service)
}