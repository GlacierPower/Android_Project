package com.example.kollin.domain.Items

import com.example.kollin.model.ItemsModel
import javax.inject.Inject

class ItemsInteractor @Inject constructor(private val itemsRepository: ItemsRepository) {
    fun getDate(): List<ItemsModel>{
        return itemsRepository.getData()
    }
}