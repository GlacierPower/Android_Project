package com.example.kollin.presentation.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.kollin.data.ItemsRepositoryImpl
import com.example.kollin.domain.ItemsInteractor


class MyViewModelFactory(private val itemsInteractor: ItemsInteractor) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ItemsViewModel(itemsInteractor) as T
    }
}