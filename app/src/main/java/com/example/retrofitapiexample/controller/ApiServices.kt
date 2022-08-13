package com.example.retrofitapiexample.controller

import com.example.retrofitapiexample.model.PostModelItem
import retrofit2.Call
import retrofit2.http.*

interface ApiServices {

    @GET("posts")
    fun getPostData(): Call<List<PostModelItem>>

    @GET("posts")
    fun getFilteredPostsData(@Query("userId") userId : Int): Call<List<PostModelItem>>

    //Use of query map
    //1 just use query multiple times
    @GET("posts")
    fun getAllFilteredPostsDataUsingMultipleQuery(@Query("userId") userId : Int, @Query("id") id : Int): Call<List<PostModelItem>>
    //2 Or use QueryMap
    @GET("posts")
    fun getAllFilteredPostsDataUsingQueryMap(@QueryMap filter : HashMap<String, Int>): Call<List<PostModelItem>>

    @GET("posts/{id}")
    fun getPostDataId(@Path("id") id : Int): Call<PostModelItem>

    @GET("posts/{id}")
    fun getPostDataPathAndQuery(@Path("id") id : Int, @Query("userId") userId : Int): Call<PostModelItem>

    @GET("posts")
    fun getMessage(@Url anotherUrl : String) : Call<String>//here when i call getMessage method than inside it i have to pass the URL

    @POST("posts")
    fun postData(@Body postModel : PostModelItem): Call<PostModelItem>

}