package com.example.kollin.presentation.view.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kollin.R

class OnBoardingViewModel : ViewModel() {

    private val _nav = MutableLiveData<NavigateToItems?>()
    val onBoardingText = MutableLiveData<String>("Default value")
    val nav: LiveData<NavigateToItems?> = _nav
    fun finishBtnClicked() {
        _nav.value = NavigateToItems(
            R.id.onBoardingFragment,
            R.id.action_onBoardingFragment_to_itemsFragment,
        )
    }

    fun finishPerformed() {
        _nav.value = null
    }

}

data class NavigateToItems(
    val destinationID: Int,
    val removeFragmentID: Int
)