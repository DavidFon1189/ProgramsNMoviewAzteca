
package com.david.programsnmoviestvazteca.ui.detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun MediaDetailRoute(
    mediaId: Int,
    onBackClick: () -> Unit,
    viewModel: MediaDetailViewModel = hiltViewModel()
) {

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(mediaId) {
        viewModel.loadTvNMoviesIfNeeded(mediaId)
    }

    when (val state = uiState) {

        MediaDetailUiState.Idle,
        MediaDetailUiState.Loading -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }

        is MediaDetailUiState.Success -> {
            MediaDetailScreen(
                media = state.media,
                onBackClick = onBackClick
            )
        }

        is MediaDetailUiState.Error -> {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(24.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = state.message)

                Button(
                    onClick = {
                        viewModel.getTvNMoviesDetails(mediaId)
                    },
                    modifier = Modifier.padding(top = 16.dp)
                ) {
                    Text("Reintentar")
                }

                Button(
                    onClick = onBackClick,
                    modifier = Modifier.padding(top = 8.dp)
                ) {
                    Text("Regresar")
                }
            }
        }
    }
}
