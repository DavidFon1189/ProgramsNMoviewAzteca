package com.david.programsnmoviestvazteca.data.remote.api

import com.david.programsnmoviestvazteca.data.remote.dto.MediaContentDto
import retrofit2.http.GET
import retrofit2.http.Path

interface MediaApi {
    @GET("shows")
    suspend fun getShows() : List<MediaContentDto>

    @GET("shows/{id}")
    suspend fun getShowsDetails(
        @Path("id") id: Int
    ): MediaContentDto
}