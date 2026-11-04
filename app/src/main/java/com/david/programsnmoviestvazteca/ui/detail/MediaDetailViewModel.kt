package com.david.programsnmoviestvazteca.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.david.programsnmoviestvazteca.domain.usecase.MediaDetailsUseCase
import com.david.programsnmoviestvazteca.ui.home.HomeUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MediaDetailViewModel @Inject constructor(
    private val mediaDetailsUseCase: MediaDetailsUseCase
): ViewModel() {
    private val _uiState = MutableStateFlow<MediaDetailUiState>(MediaDetailUiState.Idle)

    val uiState = _uiState.asStateFlow()

    fun loadTvNMoviesIfNeeded(mediaId: Int) {
        if (_uiState.value != MediaDetailUiState.Idle) {
            return
        }

        getTvNMoviesDetails(mediaId)
    }

    fun getTvNMoviesDetails(mediaId: Int) {
        viewModelScope.launch {
            _uiState.value = MediaDetailUiState.Loading
            try {
                val media = mediaDetailsUseCase(mediaId)

                _uiState.value = MediaDetailUiState.Success(
                    media
                )
            } catch (e: Exception) {
                _uiState.value = MediaDetailUiState.Error(e.message ?: "Error al cargar informacion")
            }
        }
    }
}