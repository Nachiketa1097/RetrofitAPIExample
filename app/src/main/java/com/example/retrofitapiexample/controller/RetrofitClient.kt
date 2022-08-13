package com.example.retrofitapiexample.controller

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {

    val BASE_URL = "https://jsonplaceholder.typicode.com"

    public fun getRetrofit():Retrofit {
        val retrofit : Retrofit =  Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit
    }

}