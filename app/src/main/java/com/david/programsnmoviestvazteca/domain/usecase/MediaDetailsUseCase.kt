package com.david.programsnmoviestvazteca.domain.usecase

import com.david.programsnmoviestvazteca.domain.model.MediaContent
import com.david.programsnmoviestvazteca.domain.repository.MediaRepository
import javax.inject.Inject

class MediaDetailsUseCase @Inject constructor(
    private val mediaRepository: MediaRepository
) {
    suspend operator fun invoke(mediaId: Int) : MediaContent {
        return mediaRepository.getMoviesNTVDetails(mediaId)
    }
}