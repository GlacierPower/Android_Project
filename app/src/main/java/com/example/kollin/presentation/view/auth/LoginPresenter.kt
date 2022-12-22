package com.example.kollin.presentation.view.auth

import com.example.kollin.domain.auth.AuthInteractor
import javax.inject.Inject

class LoginPresenter @Inject constructor(
    private val authInteractor: AuthInteractor
) {

    private lateinit var loginView: LoginView

    fun setView(loginFragment: LogFragment){
        loginView = loginFragment
    }

    fun loginUser(userName: String, userPass: String) {
        authInteractor.loginUser(userName, userPass)
        loginView.userLoggedIn()

    }
}