package com.cincinnatiaiexample.myalbumsapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.cincinnatiaiexample.myalbumsapplication.model.Album
import com.cincinnatiaiexample.myalbumsapplication.ui.theme.AlbumViewModel


class MainActivity : ComponentActivity() {

    private val viewModel: AlbumViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { AlbumsApp(viewModel) }
    }
}

@Composable
fun AlbumsApp(viewModel: AlbumViewModel) {
    val albums by viewModel.albums.observeAsState(emptyList())

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        items(albums) { album -> AlbumRow(album) }
    }
}

@Composable
fun AlbumRow(photo: Album) {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp)
    ) {
        AsyncImage(
            model = photo.thumbnailUrl,
            contentDescription = null,
            modifier = Modifier
                .size(64.dp)
                .padding(end = 10.dp),
            contentScale = ContentScale.Crop
        )
        Text(
            text = photo.title,
            modifier = Modifier.alignByBaseline()
        )
    }
}