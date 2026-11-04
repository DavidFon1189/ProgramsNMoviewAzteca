package com.david.programsnmoviestvazteca.ui.detail

import com.david.programsnmoviestvazteca.domain.model.MediaContent

sealed interface MediaDetailUiState {

    data object Idle : MediaDetailUiState

    data object Loading : MediaDetailUiState

    data class Success(
        val media: MediaContent
    ) : MediaDetailUiState

    data class Error(
        val message: String
    ) : MediaDetailUiState
}