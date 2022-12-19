package com.example.kollin.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.kollin.domain.Items.ItemsInteractor
import com.example.kollin.presentation.view.home.ItemsViewModel


class MyViewModelFactory(private val itemsInteractor: ItemsInteractor) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ItemsViewModel(itemsInteractor) as T
    }
}