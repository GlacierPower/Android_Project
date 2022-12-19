package com.example.kollin.data.auth

import android.content.SharedPreferences
import com.example.kollin.data.sharedprefs.ShredPreferencesHelper
import com.example.kollin.domain.auth.AuthRepository
import com.example.kollin.model.UserModel
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val sharedPreferencesHelper: ShredPreferencesHelper
) : AuthRepository {
    override fun loginUser(userName: String, userPassword: String) {
        sharedPreferencesHelper.saveUserName(userName)
        sharedPreferencesHelper.saveUserPass(userPassword)
    }

    override fun showUserCreds(): UserModel {
        return sharedPreferencesHelper.getUserCreds()
    }

    override fun doesUserExist(): Boolean {
        return sharedPreferencesHelper.checkUserExist()
    }

    override fun userLogout() {
        sharedPreferencesHelper.removeUser()
    }


}