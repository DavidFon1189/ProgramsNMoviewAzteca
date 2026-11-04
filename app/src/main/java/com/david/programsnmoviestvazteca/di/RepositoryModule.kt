package com.david.programsnmoviestvazteca.di

import com.david.programsnmoviestvazteca.data.repository.MediaRepositoryImpl
import com.david.programsnmoviestvazteca.domain.repository.MediaRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindMediaRepository(
        impl: MediaRepositoryImpl
    ): MediaRepository
}