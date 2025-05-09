package com.cincinnatiaiexample.myalbumsapplication.network

import com.cincinnatiaiexample.myalbumsapplication.model.Album
import retrofit2.http.GET

interface AlbumsAPI {
    @GET("/photos")
    suspend fun getPhotos(): List<Album>
}




