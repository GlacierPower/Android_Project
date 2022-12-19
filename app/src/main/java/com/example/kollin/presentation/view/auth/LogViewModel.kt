package com.example.kollin.presentation.view.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kollin.domain.auth.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LogViewModel @Inject constructor(
    private val authRepository: AuthRepository
) : ViewModel(){
    private val _nav = MutableLiveData<Unit?>()
    val nav: LiveData<Unit?> = _nav

    fun loginUser(userName: String, userPassword: String) {
        authRepository.loginUser(userName, userPassword)
        _nav.value = Unit
    }
}