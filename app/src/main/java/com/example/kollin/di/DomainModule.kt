package com.example.kollin.di

import com.example.kollin.domain.Items.ItemsInteractor
import com.example.kollin.domain.Items.ItemsRepository
import com.example.kollin.domain.auth.AuthInteractor
import com.example.kollin.domain.auth.AuthRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DomainModule {
    @Provides
    fun provideItemsInteractor(
        itemsRepository: ItemsRepository
    ): ItemsInteractor {
        return ItemsInteractor(itemsRepository)
    }

    @Provides
    fun provideAuthInteractor(
        authRepository: AuthRepository
    ): AuthInteractor {
        return AuthInteractor(authRepository)
    }
}