package com.example.kollin.presentation.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kollin.R
import com.example.kollin.presentation.adapter.listener.ItemsListener
import com.example.kollin.model.ItemsModel


class ItemsViewHolder(
    private val view: View,
    private val itemListener: ItemsListener
) : RecyclerView.ViewHolder(view) {
    fun bind(itemsModel: ItemsModel) {
        val name = view.findViewById<TextView>(R.id.tv_name)
        val date = view.findViewById<TextView>(R.id.tv_date)
        val imageView = view.findViewById<ImageView>(R.id.iv_name)


        name.text = itemsModel.name
        imageView.setBackgroundResource(itemsModel.image)
        date.text = itemsModel.date

        imageView.setOnClickListener{
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