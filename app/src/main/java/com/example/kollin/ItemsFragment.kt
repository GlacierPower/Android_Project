package com.example.kollin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kollin.BundleConstance.DATE
import com.example.kollin.BundleConstance.IMAGE_VIEW
import com.example.kollin.adapter.ItemsAdapter
import com.example.kollin.listener.ItemsListener


class ItemsFragment : Fragment(), ItemsListener {

    private lateinit var itemsAdapter: ItemsAdapter

    private val viewModel: ItemsViewModel by viewModels()

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

        viewModel.getData()
        viewModel.items.observe(viewLifecycleOwner) { listItems ->
            itemsAdapter.submitList(listItems)
        }
        viewModel.msg.observe(viewLifecycleOwner) { msg ->
            Toast.makeText(context, getString(msg), Toast.LENGTH_SHORT).show()
        }
        viewModel.bundle.observe(viewLifecycleOwner) { navBundle ->
            if (navBundle != null) {
                val detailsFragment = DetailsFragment()
                val bundle = Bundle()

                bundle.putString(NAME, navBundle.name)
                bundle.putString(DATE, navBundle.date)
                bundle.putInt(IMAGE_VIEW, navBundle.image)
                detailsFragment.arguments = bundle

                parentFragmentManager
                    .beginTransaction()
                    .replace(R.id.activityContainer, detailsFragment)
                    .addToBackStack("Details")
                    .commit()

                //in the end of our action
                viewModel.userNavigated()
            }
        }
    }

    override fun onClick() {
        viewModel.imageViewClicked()
    }

    override fun onElementSelcted(name: String, date: String, imageView: Int) {
        viewModel.elementClicked(name, date, imageView)
    }

    companion object {
        //when we want to see where use this const
        const val NAME = "name"
    }
}

