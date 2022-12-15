package com.example.kollin.presentation.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class OnBoardingViewModel :ViewModel() {
    private val _nav = MutableLiveData<Unit?>()
    val onBoardingText = MutableLiveData<String>("Default value")
    val nav :LiveData<Unit?> = _nav
    fun finishBtnClicked(){
        _nav.value = Unit
    }

    fun finishPerformed(){
        _nav.value = null
    }

}