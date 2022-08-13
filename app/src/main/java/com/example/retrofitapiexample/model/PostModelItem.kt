package com.example.retrofitapiexample.model

import com.google.gson.annotations.SerializedName


data class PostModelItem(

    @SerializedName("userId")
    val userId : Int,

    @SerializedName("id")
    val id : Int,

    @SerializedName("title")
    val title : String,

    @SerializedName("body")
    val body : String
)