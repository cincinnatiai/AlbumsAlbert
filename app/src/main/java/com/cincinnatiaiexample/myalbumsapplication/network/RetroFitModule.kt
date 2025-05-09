package com.cincinnatiaiexample.myalbumsapplication.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitModule {
    private const val BASE_URL = "https://jsonplaceholder.typicode.com/"

    val api: AlbumsAPI = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(AlbumsAPI::class.java)
}
