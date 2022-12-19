package com.example.kollin.domain.Items

import com.example.kollin.model.ItemsModel

interface ItemsRepository {
    fun getData():List<ItemsModel>
}