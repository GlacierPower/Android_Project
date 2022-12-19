package com.example.kollin.domain.auth

import com.example.kollin.model.UserModel

interface AuthRepository {

    fun loginUser(userName: String, userPassword: String)

    fun showUserCreds():UserModel

    fun doesUserExist():Boolean

    fun userLogout()
}