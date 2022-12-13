package com.example.kollin.domain

import com.example.kollin.model.ItemsModel

interface ItemsRepository {
    fun getData():List<ItemsModel>
}