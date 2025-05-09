package com.cincinnatiaiexample.myalbumsapplication.ui.theme

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cincinnatiaiexample.myalbumsapplication.model.Album
import com.cincinnatiaiexample.myalbumsapplication.repository.AlbumRepositoryImpl
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AlbumViewModel(
    private val repo: AlbumRepositoryImpl = AlbumRepositoryImpl()
) : ViewModel() {

    private val _albums = MutableLiveData<List<Album>>(emptyList())
    val albums: LiveData<List<Album>> = _albums

    init {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                _albums.postValue(repo.fetchPhotos())
            } catch (_: Exception) {
            }
        }
    }
}

