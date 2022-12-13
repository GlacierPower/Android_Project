package com.example.kollin.presentation.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kollin.R
import com.example.kollin.data.ItemsRepositoryImpl
import com.example.kollin.model.ItemsModel

class ItemsViewModel(private val carsRepositoryImpl: ItemsRepositoryImpl) : ViewModel() {

    private val _items = MutableLiveData<List<ItemsModel>>()
    val items: LiveData<List<ItemsModel>> = _items

    private val _msg = MutableLiveData<Int>()
    val msg: LiveData<Int> = _msg

    private val _bundle = MutableLiveData<NavigateWithBundle?>()
    val bundle: LiveData<NavigateWithBundle?> = _bundle

    fun getData() {

        _items.value = carsRepositoryImpl.getData()
    }

    fun imageViewClicked() {
        _msg.value = R.string.image_view_clicked
    }

    fun elementClicked(name: String, date: String, imageView: Int) {
        _bundle.value = NavigateWithBundle(
            name = name,
            date = date,
            image = imageView
        )
    }

    fun userNavigated() {
        _bundle.value = null
    }
}

data class NavigateWithBundle(
    val image: Int,
    val name: String,
    val date: String
)

