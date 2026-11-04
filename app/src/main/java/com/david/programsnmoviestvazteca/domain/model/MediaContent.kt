package com.david.programsnmoviestvazteca.domain.model


data class MediaContent(
    val id: Int,
    val name: String,
    val imagenUrl: String?,
    val description: String?,
    val type: String?,
    val categories: List<String>?,
    val language: String?
)


