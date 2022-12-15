package com.example.kollin.presentation.view.data_binding

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {
    val userName = MutableLiveData<String>()
    val userPassword = MutableLiveData<String>()

    val userCreds = MutableLiveData<String>()

    fun showCreds() {
        userCreds.value = "${userName.value.toString()}\n ${userPassword.value.toString()}"
    }

}