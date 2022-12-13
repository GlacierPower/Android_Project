package com.example.kollin.presentation.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.kollin.data.ItemsRepositoryImpl


class MyViewModelFactory(private val carsRepositoryImpl: ItemsRepositoryImpl) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ItemsViewModel(carsRepositoryImpl) as T
    }
}