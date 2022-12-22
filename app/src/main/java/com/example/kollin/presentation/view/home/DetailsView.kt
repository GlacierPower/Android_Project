package com.example.kollin.presentation.view.home

interface DetailsView {

    fun userLoggedOut()

    fun displayItemData(name: String, date: String, imageView: Int)
}