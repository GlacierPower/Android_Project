package com.example.kollin.presentation.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.kollin.ItemsViewModel
import com.example.kollin.TestParametr

class MyViewModelFactory(private val testParametr: TestParametr) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ItemsViewModel(testParametr) as T
    }
}