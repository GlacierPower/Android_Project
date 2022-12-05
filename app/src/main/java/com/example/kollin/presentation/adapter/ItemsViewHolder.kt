package com.example.kollin.presentation.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.example.kollin.R
import com.example.kollin.databinding.ItemFruitBinding
import com.example.kollin.presentation.adapter.listener.ItemsListener
import com.example.kollin.model.ItemsModel


class ItemsViewHolder(
    private val viewBinding: ItemFruitBinding,
    private val itemListener: ItemsListener
) : RecyclerView.ViewHolder(viewBinding.root) {
    fun bind(itemsModel: ItemsModel) {

        viewBinding.tvName.text = itemsModel.name
        viewBinding.ivImage.setBackgroundResource(itemsModel.image)
        viewBinding.tvDate.text = itemsModel.date

        viewBinding.ivImage.setOnClickListener{
            itemListener.onClick()
        }
        itemView.setOnClickListener {
            itemListener.onElementSelcted(itemsModel.name,
            itemsModel.date,
            itemsModel.image
                )
        }
    }
}