package com.example.kollin.presentation.view

import com.example.kollin.domain.auth.AuthInteractor
import javax.inject.Inject

class MainActivityPresenter @Inject constructor(
    private val authInteractor: AuthInteractor
) {
    private lateinit var mainView: MainView

    fun setView(mainActivity: MainActivity) {
        mainView = mainActivity

    }

    fun checkUserExists() {
        val doesUserExists = authInteractor.checkUserExist()
        mainView.userExistsResult(doesUserExists)
    }

}