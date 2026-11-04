package com.david.programsnmoviestvazteca.ui.home

import com.david.programsnmoviestvazteca.domain.model.CategoryContent

object CategoriesData {
    val items = listOf(
        CategoryContent(
            id = 1,
            title = "Películas y programas recientes",
            imageUrl = "https://image.tmdb.org/t/p/w500/gEU2QniE6E77NI6lCU6MxlNBvIx.jpg",
            description = "Descubre nuevos contenidos",
            category = "Recientes"
        ),
        CategoryContent(
            id = 2,
            title = "Los más populares",
            imageUrl = "https://image.tmdb.org/t/p/w500/qJ2tW6WMUDux911r6m7haRef0WH.jpg",
            description = "Explora los favoritos",
            category = "Populares"
        ),
        CategoryContent(
            id = 3,
            title = "Ciencia ficción",
            imageUrl = "https://image.tmdb.org/t/p/w500/gEU2QniE6E77NI6lCU6MxlNBvIx.jpg",
            description = "Historias de otros mundos",
            category = "Ciencia ficción"
        ),
        CategoryContent(
            id = 4,
            title = "Acción y aventura",
            imageUrl = "https://image.tmdb.org/t/p/w500/qJ2tW6WMUDux911r6m7haRef0WH.jpg",
            description = "Emoción y aventura",
            category = "Acción"
        )
    )
}