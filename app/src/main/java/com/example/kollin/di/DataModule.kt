package com.example.kollin.di

import android.content.Context
import android.content.Context.MODE_PRIVATE
import com.example.kollin.data.auth.AuthRepositoryImpl
import com.example.kollin.data.items.ItemsRepositoryImpl
import com.example.kollin.data.sharedprefs.ShredPreferencesHelper
import com.example.kollin.domain.Items.ItemsRepository
import com.example.kollin.domain.auth.AuthRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {
    @Binds
    abstract fun bindItemsRepository(
        itemsRepositoryImpl: ItemsRepositoryImpl
    ): ItemsRepository

    @Binds
    abstract fun bindAuthRepository(
        authRepositoryImpl: AuthRepositoryImpl
    ): AuthRepository

    companion object{
        private const val SP_KEY = "SP_KEY"
        @Provides
        fun provideSharedPreferences(
            @ApplicationContext context :Context) : ShredPreferencesHelper {
            return ShredPreferencesHelper(context.getSharedPreferences(SP_KEY,MODE_PRIVATE))
        }
    }
}