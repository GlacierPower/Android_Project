package com.example.kollin.data.sharedprefs

import android.content.SharedPreferences
import com.example.kollin.model.UserModel
import javax.inject.Inject

class ShredPreferencesHelper @Inject constructor(
    private val sharedPreferences: SharedPreferences
) {
    fun saveUserName(name: String?) {
        sharedPreferences.edit().putString(USER_NAME, name).apply()
    }

    fun saveUserPass(pass: String?) {
        sharedPreferences.edit().putString(USER_PASS, pass).apply()
    }

    fun getUserCreds(): UserModel {
        val name = sharedPreferences.getString(USER_NAME, "") ?: "No user"
        val pass = sharedPreferences.getString(USER_PASS, "") ?: "No pass"
        return UserModel(name, pass)
    }

    fun checkUserExist():Boolean{
        val name = sharedPreferences.getString(USER_NAME, "")
        val pass = sharedPreferences.getString(USER_PASS, "")
        return (!name.isNullOrEmpty()&&!pass.isNullOrEmpty())
    }

    fun removeUser(){
        saveUserName(null)
        saveUserPass(null)
    }

    companion object {
        private const val USER_NAME = "USER_NAME"
        private const val USER_PASS = "USER_PASS"
    }
}