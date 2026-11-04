
package com.david.programsnmoviestvazteca.ui.home

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.david.programsnmoviestvazteca.domain.model.CategoryContent
import com.david.programsnmoviestvazteca.domain.model.MediaContent

@Composable
fun HomeRoute(
    featuredItems: List<CategoryContent>,
    onMediaClick: (MediaContent) -> Unit,
    viewModel: HomeViewModel = hiltViewModel()
) {

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val isRefreshing by viewModel.isRefreshing.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.loadTvNMoviesIfNeeded()
    }

    val mediaItems: List<MediaContent> = when (val state = uiState) {
        is HomeUiState.Success -> state.mediaContent
        else -> emptyList()
    }

    HomeScreen(
        featuredItems = featuredItems,
        mediaItems = mediaItems,
        onMediaClick = onMediaClick,
        isLoading = uiState == HomeUiState.Idle ||
                uiState == HomeUiState.Loading,
        errorMessage = (uiState as? HomeUiState.Error)?.message,
        isRefreshing = isRefreshing,
        onRefresh = viewModel::refreshMedia
    )
}
