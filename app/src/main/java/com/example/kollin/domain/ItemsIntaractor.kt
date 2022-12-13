package com.example.kollin.domain

import com.example.kollin.model.ItemsModel

class ItemsIntaractor(private val itemsRepository: ItemsRepository) {
    fun getDate(): List<ItemsModel>{
        return itemsRepository.getData()
    }
}