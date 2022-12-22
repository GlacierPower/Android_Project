package com.example.kollin.presentation.view.home

import com.example.kollin.model.ItemsModel

interface ItemsView {

    fun itemsReceived(itemsList :List<ItemsModel>)

    fun imageViewClicked(message: Int)

    fun itemClicked(navigationData : NavigateWithBundle
    )

}