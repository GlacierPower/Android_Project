package com.example.kollin.data

import com.example.kollin.R
import com.example.kollin.domain.ItemsRepository
import com.example.kollin.model.ItemsModel

class ItemRepositoryImpl : ItemsRepository {
    override fun getData(): List<ItemsModel> {
        val listItems = listOf<ItemsModel>(
            ItemsModel(R.drawable.apple, "Android", "20.01.23"),
            ItemsModel(R.drawable.first, "IOS", "15.02.13"),
            ItemsModel(R.drawable.second, "Flutter", "14.02.15"),
            ItemsModel(R.drawable.third, "Python", "16.11.34"),
            ItemsModel(R.drawable.fourth, "Xamarin", "12.12.61"),
            ItemsModel(R.drawable.apple, ".NET", "02.10.24"),
            ItemsModel(R.drawable.first, "C++", "16.09.23"),
            ItemsModel(R.drawable.second, "C", "11.04.23"),
            ItemsModel(R.drawable.third, "PHP", "13.07.23"),
            ItemsModel(R.drawable.fourth, "Ruby on Rails", "14.07.23"),
            ItemsModel(R.drawable.apple, "JS", "15.07.23")
        )
        return listItems
    }
}