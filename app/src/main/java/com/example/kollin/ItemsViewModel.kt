package com.example.kollin

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kollin.model.ItemsModel

class ItemsViewModel(private  val testParametr: TestParametr) : ViewModel() {

    private val _items = MutableLiveData<List<ItemsModel>>()
    val items: LiveData<List<ItemsModel>> = _items

    private val _msg = MutableLiveData<Int>()
    val msg: LiveData<Int> = _msg

    private val _bundle = MutableLiveData<NavigateWithBundle?>()
    val bundle: LiveData<NavigateWithBundle?> = _bundle

    fun getData() {
        val listItems = listOf<ItemsModel>(
            ItemsModel(
                R.drawable.apple,
                "Android",
                "20.01.23"
            ),
            ItemsModel(
                R.drawable.first,
                "IOS",
                "15.02.13"
            ),
            ItemsModel(
                R.drawable.second,
                "Flutter",
                "14.02.15"
            ),
            ItemsModel(
                R.drawable.third,
                "Python",
                "16.11.34"
            ),
            ItemsModel(
                R.drawable.fourth,
                "Xamarin",
                "12.12.61"
            ),
            ItemsModel(
                R.drawable.apple,
                ".NET",
                "02.10.24"
            ),
            ItemsModel(
                R.drawable.first,
                "C++",
                "16.09.23"
            ),
            ItemsModel(
                R.drawable.second,
                "C",
                "11.04.23"
            ),
            ItemsModel(
                R.drawable.third,
                "PHP",
                "13.07.23"
            ),
            ItemsModel(
                R.drawable.fourth,
                "Ruby on Rails",
                "14.07.23"
            ),
            ItemsModel(
                R.drawable.apple,
                "JS",
                "15.07.23"
            )
        )
        _items.value = listItems
    }

    fun imageViewClicked() {
        _msg.value = R.string.image_view_clicked
    }

    fun elementClicked(name: String, date: String, imageView: Int) {
        _bundle.value = NavigateWithBundle(
            name = name,
            date = date,
            image = imageView
        )
    }

    fun userNavigated(){
        _bundle.value =null
    }
}

data class NavigateWithBundle(
    val image: Int,
    val name: String,
    val date: String
)

class TestParametr()