package com.david.programsnmoviestvazteca

import com.david.programsnmoviestvazteca.domain.model.MediaContent
import com.david.programsnmoviestvazteca.domain.repository.MediaRepository
import com.david.programsnmoviestvazteca.domain.usecase.MediaUseCase
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import org.mockito.kotlin.whenever

class GetProgramsNMoviesUseCaseTest {

    private lateinit var repository: MediaRepository
    private lateinit var mediaUseCase: MediaUseCase

    @Before
    fun setUp() {
        repository = mock(MediaRepository::class.java)
        mediaUseCase = MediaUseCase(repository)
    }

    @Test
    fun `invoke returns shows from repository`() = runTest {
        val categories = listOf(
            "Reciente",
            "Nuevo",
            "Recomendado"
        )
        val expectedShows = listOf(
            MediaContent(
                id = 1,
                name = "Películas y programas recientes",
                imagenUrl = "https://image.tmdb.org/t/p/w500/gEU2QniE6E77NI6lCU6MxlNBvIx.jpg",
                description = "Descubre nuevos contenidos",
                type = "",
                categories = categories,
                language = "English"

            )
        )

        whenever(repository.getMoviesNTV())
            .thenReturn(expectedShows)


        val result = mediaUseCase()

        assertEquals(expectedShows, result)
        verify(repository).getMoviesNTV()
    }

    @Test
    fun `invoke returns empty list when repository is empty`() = runTest {
        whenever(repository.getMoviesNTV())
            .thenReturn(emptyList())

        val result = mediaUseCase()

        assertEquals(emptyList<MediaContent>(), result)
        verify(repository).getMoviesNTV()
    }
}