package com.example.retrofitapiexample.controller

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceBuilder {

    //Live server URL
    private const val URL = "https://jsonplaceholder.typicode.com/"

    //Create OkHttp Client
    private val okHttp = OkHttpClient.Builder()

    //Create Retrofit Builder
    private val builder = Retrofit.Builder().baseUrl(URL)
                            .addConverterFactory(GsonConverterFactory.create())
                            .client(okHttp.build())

    private val retrofit = builder.build()

    fun <T> buildService(serviceType:Class<T>) : T{
        return retrofit.create(serviceType)
    }
}