package com.david.programsnmoviestvazteca.domain.usecase

import com.david.programsnmoviestvazteca.domain.model.MediaContent
import com.david.programsnmoviestvazteca.domain.repository.MediaRepository
import javax.inject.Inject

class MediaUseCase @Inject constructor(
    private val mediaRepository: MediaRepository
) {
    suspend operator fun invoke() : List<MediaContent> {
        return mediaRepository.getMoviesNTV()
    }
}