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

class ItemsFragment : Fragment(), ItemsListener, ItemsView {

    private lateinit var itemsAdapter: ItemsAdapter

    lateinit var itemsPresenter: ItemsPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_items, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        itemsPresenter = ItemsPresenter(this)
        itemsAdapter = ItemsAdapter(this)

        val recycleView = view.findViewById<RecyclerView>(R.id.recycleView)
        recycleView.layoutManager = LinearLayoutManager(context)
        recycleView.adapter = itemsAdapter

        itemsPresenter.getDate()

    }

    override fun onClick() {
        itemsPresenter.imageViewClicked()
    }

    override fun onElementSelcted(name: String, date: String, imageView: Int) {
        itemsPresenter.elementSelected(name, date, imageView)

    }

    override fun dataReceive(list: List<ItemsModel>) {
        itemsAdapter.submitList(list)
    }

    override fun imageViewClicked(msg: Int) {
        Toast.makeText(context, getString(msg), Toast.LENGTH_SHORT).show()
    }

    override fun goDetails(name: String, date: String, imageView: Int) {
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
            .replace(R.id.activityContainer, detailsFragment)
            .addToBackStack(null)
            .commit()
    }
}
