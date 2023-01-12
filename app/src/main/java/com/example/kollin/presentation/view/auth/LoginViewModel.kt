package com.example.kollin.presentation.view.auth

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kollin.R
import com.example.kollin.domain.auth.AuthInteractor
import com.example.kollin.domain.auth.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val authInteractor: AuthInteractor
) : ViewModel() {

    private val _nav = MutableLiveData<Int?>()
    val nav: LiveData<Int?> = _nav

    fun loginUser(userName: String, userPassword: String) {

        val coroutineExceptionHandler = CoroutineExceptionHandler { _, exceprion ->
            Log.w("exception called", exceprion.toString())
        }
        viewModelScope.launch(
            CoroutineName("with exception")
                    + Dispatchers.Main + coroutineExceptionHandler
        ) {
            try {
                launch {
                    authInteractor.loginUser(userName, userPassword)
                    _nav.value = R.id.action_logFragment_to_homeFragment
                }

            } catch (e: Exception) {
                Log.w("exception", "loginUser FAILED")
            }

        }
    }

    fun userNavigated() {
        _nav.value = null
    }
}