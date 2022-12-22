package com.example.kollin.presentation.view.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kollin.R
import com.example.kollin.model.ItemsModel
import com.example.kollin.presentation.adapter.ItemsAdapter
import com.example.kollin.presentation.adapter.listener.ItemsListener
import com.example.kollin.utils.BundleConstance.DATE
import com.example.kollin.utils.BundleConstance.IMAGE_VIEW
import com.example.kollin.utils.NavigationOnFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ItemsFragment : Fragment(), ItemsListener, ItemsView {

    private lateinit var itemsAdapter: ItemsAdapter

    @Inject
    lateinit var itemsPresenter: ItemsPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_items, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        itemsPresenter.setView(this)

        itemsAdapter = ItemsAdapter(this)
        val recycleView = view.findViewById<RecyclerView>(R.id.recycleView)
        recycleView.layoutManager = LinearLayoutManager(context)
        recycleView.adapter = itemsAdapter

        itemsPresenter.getItems()

    }

    override fun onClick() {
        itemsPresenter.imageViewClicked()
    }

    override fun onElementSelected(name: String, date: String, imageView: Int) {
        itemsPresenter.itemClicked(name, date, imageView)
    }


    override fun itemsReceived(itemsList: List<ItemsModel>) {
        itemsAdapter.submitList(itemsList)
    }

    override fun imageViewClicked(message: Int) {
        Toast.makeText(context, getString(message), Toast.LENGTH_SHORT).show()
    }

    override fun itemClicked(navigationData: NavigateWithBundle) {
        val detailsFragment = DetailsFragment()
        val bundle = Bundle()

        bundle.putString(NAME, navigationData.name)
        bundle.putString(DATE, navigationData.date)
        bundle.putInt(IMAGE_VIEW, navigationData.image)
        detailsFragment.arguments = bundle

        NavigationOnFragment.replaceFragment(
            parentFragmentManager,
            detailsFragment,
            true
        )
    }

    companion object {
        //when we want to see where use this const
        const val NAME = "name"
    }
}

