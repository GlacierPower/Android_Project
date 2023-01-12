package com.example.kollin.presentation.view.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kollin.R
import com.example.kollin.domain.auth.AuthInteractor
import com.example.kollin.model.UserModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val authInteractor: AuthInteractor) : ViewModel() {

    private val _userCreds = MutableLiveData<UserModel>()
    val userCreds: LiveData<UserModel> = _userCreds

    private val _nav = MutableLiveData<Int?>()
    val nav: LiveData<Int?> = _nav

    fun showUserData() {
        viewModelScope.launch {
            _userCreds.value = authInteractor.getUserCreds()
        }

    }

    fun navigateToRecycler(){
        _nav.value = R.navigation.main_graph
    }
}

