package com.example.kollin

import com.example.kollin.model.ItemsModel

interface ItemsView {
    fun dataReceive(list:List<ItemsModel>)

    fun imageViewClicked(msg:Int)

    fun goDetails(name: String, date: String, imageView: Int)
}