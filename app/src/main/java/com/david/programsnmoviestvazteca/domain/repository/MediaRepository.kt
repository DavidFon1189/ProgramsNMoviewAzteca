package com.david.programsnmoviestvazteca.domain.repository

import com.david.programsnmoviestvazteca.domain.model.MediaContent

interface MediaRepository {
    suspend fun getMoviesNTV(): List<MediaContent>

    suspend fun getMoviesNTVDetails(id: Int): MediaContent
}