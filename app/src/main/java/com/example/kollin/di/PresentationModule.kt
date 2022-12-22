package com.example.kollin.di

import com.example.kollin.domain.Items.ItemsInteractor
import com.example.kollin.domain.auth.AuthInteractor
import com.example.kollin.presentation.view.MainActivityPresenter
import com.example.kollin.presentation.view.auth.LoginPresenter
import com.example.kollin.presentation.view.auth.OnBoardingPresenter
import com.example.kollin.presentation.view.home.DetailsPresenter
import com.example.kollin.presentation.view.home.ItemsPresenter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class PresentationModule {

    @Provides
    fun provideMainActivityPresentation(
        authInteractor: AuthInteractor
    ): MainActivityPresenter {
        return MainActivityPresenter(authInteractor)
    }

    @Provides
    fun provideLoginPresentation(
        authInteractor: AuthInteractor
    ): LoginPresenter {
        return LoginPresenter(authInteractor)
    }

    @Provides
    fun provideOnBoardingPresentation(
    ): OnBoardingPresenter {
        return OnBoardingPresenter()
    }

    @Provides
    fun provideItemsPresentation(
        itemsInteractor: ItemsInteractor
    ): ItemsPresenter {
        return ItemsPresenter(itemsInteractor)
    }

    @Provides
    fun provideDetailsPresentation(
        authInteractor: AuthInteractor
    ): DetailsPresenter {
        return DetailsPresenter(authInteractor)
    }
}