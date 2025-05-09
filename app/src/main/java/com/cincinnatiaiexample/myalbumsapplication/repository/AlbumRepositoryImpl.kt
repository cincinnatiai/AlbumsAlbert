package com.cincinnatiaiexample.myalbumsapplication.repository

import com.cincinnatiaiexample.myalbumsapplication.model.Album
import com.cincinnatiaiexample.myalbumsapplication.network.AlbumsAPI
import com.cincinnatiaiexample.myalbumsapplication.network.RetrofitModule


class AlbumRepositoryImpl(
    private val api: AlbumsAPI = RetrofitModule.api
) {
    suspend fun fetchPhotos(): List<Album> = api.getPhotos()
}