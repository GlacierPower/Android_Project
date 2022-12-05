package com.example.kollin.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kollin.R
import com.example.kollin.databinding.ItemFruitBinding
import com.example.kollin.presentation.adapter.listener.ItemsListener
import com.example.kollin.model.ItemsModel

class ItemsAdapter(private  val itemListener: ItemsListener
) : RecyclerView.Adapter<ItemsViewHolder>() {

    private var listItems = mutableListOf<ItemsModel>()

    fun submitList(list: List<ItemsModel>) {
        this.listItems = list.toMutableList()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemsViewHolder {
        val viewBinding = ItemFruitBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false)
        return ItemsViewHolder(viewBinding,itemListener)
    }

    override fun onBindViewHolder(holder: ItemsViewHolder, position: Int) {
        holder.bind(listItems[position])
    }

    override fun getItemCount(): Int {
        return listItems.size
    }

}