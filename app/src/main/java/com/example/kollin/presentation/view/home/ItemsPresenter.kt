package com.example.kollin.presentation.view.home

import com.example.kollin.R
import com.example.kollin.domain.Items.ItemsInteractor
import javax.inject.Inject

class ItemsPresenter @Inject constructor(private val itemsInteractor: ItemsInteractor) {

    private lateinit var itemsView: ItemsView

    fun setView(itemsFragment: ItemsFragment) {
        itemsView = itemsFragment
    }

    fun getItems() {
        val items = itemsInteractor.getDate()
        itemsView.itemsReceived(items)
    }

    fun imageViewClicked() {
        itemsView.imageViewClicked(R.string.image_view_clicked)
    }

    fun itemClicked(name: String, date: String, imageView: Int) {
        itemsView.itemClicked(NavigateWithBundle(name, date, imageView))
    }
}

data class NavigateWithBundle(
    val name: String,
    val date: String,
    val image: Int
)