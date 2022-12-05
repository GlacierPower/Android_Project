package com.example.kollin.presentation.view

import com.example.kollin.R
import com.example.kollin.domain.ItemsInteractor
import com.example.kollin.model.ItemsModel

class ItemsPresenter(
    private val itemsView: ItemsView,
    private val itemsInteractor: ItemsInteractor
) {

    fun getDate() {
        val listItems = itemsInteractor.getData()
        itemsView.dataReceive(listItems)
    }

    fun imageViewClicked() {
        itemsView.imageViewClicked(R.string.imageViewClicked)
    }

    fun elementSelected(name: String, date: String, imageView: Int) {
        itemsView.goDetails(name, date, imageView)
    }
}