package com.david.programsnmoviestvazteca.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.david.programsnmoviestvazteca.domain.usecase.MediaUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val mediaUseCase: MediaUseCase
): ViewModel() {

    private val _uiState = MutableStateFlow<HomeUiState>(HomeUiState.Idle)

    private val _isRefreshing = MutableStateFlow(false)

    val isRefreshing = _isRefreshing.asStateFlow()

    val uiState = _uiState.asStateFlow()

    fun loadTvNMoviesIfNeeded() {
        if (_uiState.value != HomeUiState.Idle) {
            return
        }

        getTvNMovies()
    }

    fun getTvNMovies() {
        viewModelScope.launch {
            _uiState.value = HomeUiState.Loading
            try {
                val media = mediaUseCase()

                _uiState.value = HomeUiState.Success(
                    media
                )
            } catch (e: Exception) {
                _uiState.value = HomeUiState.Error(e.message ?: "Error al cargar informacion")
            }
        }
    }

    fun refreshMedia() {
        if (_isRefreshing.value) return

        viewModelScope.launch {
            _isRefreshing.value = true

            try {
                val media = mediaUseCase()

                _uiState.value = HomeUiState.Success(
                    mediaContent = media
                )
            }catch (e: Exception) {
                _uiState.value = HomeUiState.Error(
                    message = e.message ?: "Error al cargar informacion"
                )
            } finally {
                _isRefreshing.value = false
            }
        }
    }
}