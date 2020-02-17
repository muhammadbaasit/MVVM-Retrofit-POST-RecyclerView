package com.example.app8mvvmretrofit.data.remote

import com.example.app8mvvmretrofit.ui.Model
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface RetrofitApi {

    @GET("posts")
    fun getData(): Call<List<Model>>

    companion object{

        var BASE_URL = "https://jsonplaceholder.typicode.com/"

        fun create() : RetrofitApi {

            val retrofit=Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()

            return retrofit.create(RetrofitApi::class.java)
        }
    }
}