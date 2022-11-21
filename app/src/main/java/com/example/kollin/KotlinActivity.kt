package com.example.kollin

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.core.content.ContextCompat.startActivity

class KotlinActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin)

        val listView = findViewById<ListView>(R.id.listView)

        val list = listOf<String>(
            "apple",
            "banana",
            "kiwi",
            "orange",
            "pineapple",
            "watermelon"
        )
        val adapter = ArrayAdapter(this, R.layout.fruit_item_layout, list)
        listView.adapter = adapter
    }

    companion object {
        fun start(context: Context) {
            val intent = Intent(context, KotlinActivity::class.java)
            context.startActivity(intent)
        }
    }
}

