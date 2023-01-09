package com.example.kollin.domain.auth

import com.example.kollin.model.UserModel

interface AuthRepository {

    suspend fun loginUser(userName: String, userPassword: String)

    suspend fun showUserCreds():UserModel

    suspend fun doesUserExist():Boolean

    suspend fun userLogout()
}