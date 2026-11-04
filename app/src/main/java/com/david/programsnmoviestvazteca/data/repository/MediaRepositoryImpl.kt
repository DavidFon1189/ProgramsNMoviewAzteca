package com.david.programsnmoviestvazteca.data.repository

import com.david.programsnmoviestvazteca.data.remote.api.MediaApi
import com.david.programsnmoviestvazteca.data.remote.mapper.toDomain
import com.david.programsnmoviestvazteca.domain.model.MediaContent
import com.david.programsnmoviestvazteca.domain.repository.MediaRepository
import javax.inject.Inject

class MediaRepositoryImpl @Inject constructor(
    private val api: MediaApi
) : MediaRepository {
    override suspend fun getMoviesNTV(): List<MediaContent> {
        return api.getShows().map { dto ->
            dto.toDomain()
        }
    }

    override suspend fun getMoviesNTVDetails(id: Int): MediaContent {
        return api.getShowsDetails(id).toDomain()
    }

}