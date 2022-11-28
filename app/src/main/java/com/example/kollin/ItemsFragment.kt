package com.example.kollin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kollin.adapter.ItemsAdapter
import com.example.kollin.listener.ItemsListener
import com.example.kollin.model.ItemsModel

class ItemsFragment : Fragment(), ItemsListener {

    private lateinit var itemsAdapter: ItemsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_items, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        itemsAdapter = ItemsAdapter(this)
        val recycleView = view.findViewById<RecyclerView>(R.id.recycleView)
        recycleView.layoutManager = LinearLayoutManager(context)
        recycleView.adapter = itemsAdapter

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
        itemsAdapter.submitList(listItems.toList())
    }

    override fun onClick() {
        Toast.makeText(context, "ImageView clicked ", Toast.LENGTH_SHORT).show()
    }

    override fun onElementSelcted(name: String, date: String, imageView: Int) {
        val detailsFragment = DetailsFragment()
        val bundle = Bundle()

        bundle.putString("name", name)
        bundle.putString("date", date)
        bundle.putInt("imageView", imageView)
        detailsFragment.arguments = bundle

        //TODO add method we will not use
        // now we will use replace and addToBackStack
        parentFragmentManager
            .beginTransaction()
            .replace(R.id.activityContainer, DetailsFragment())
            .addToBackStack(null)
            .commit()
    }
}
