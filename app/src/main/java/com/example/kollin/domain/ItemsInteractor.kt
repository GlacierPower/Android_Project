package com.example.kollin.domain

import com.example.kollin.model.ItemsModel

class ItemsInteractor(private val itemsRepository: ItemsRepository) {

    fun getData(): List<ItemsModel> {
        return itemsRepository.getData()
    }
}