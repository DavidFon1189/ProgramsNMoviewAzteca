package com.david.programsnmoviestvazteca.data.remote.mapper

import com.david.programsnmoviestvazteca.data.remote.dto.MediaContentDto
import com.david.programsnmoviestvazteca.domain.model.MediaContent

fun MediaContentDto.toDomain(): MediaContent {
    return MediaContent (
        id = id,
        name = name,
        imagenUrl = image?.medium,
        description = summary,
        type = type,
        categories = genres,
        language = language
    )
}