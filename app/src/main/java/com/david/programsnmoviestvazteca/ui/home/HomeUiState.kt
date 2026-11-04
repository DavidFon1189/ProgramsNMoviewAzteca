package com.david.programsnmoviestvazteca.ui.home

import com.david.programsnmoviestvazteca.domain.model.MediaContent

sealed interface HomeUiState {
    data object Idle: HomeUiState

    data object Loading: HomeUiState

    data class Success(
        val mediaContent: List<MediaContent>
    ) : HomeUiState

    data class Error(
        val message: String
    ): HomeUiState
}