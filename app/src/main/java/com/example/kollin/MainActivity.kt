package com.example.kollin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.kollin.KotlinActivity.Companion.start

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn = findViewById<Button>(R.id.btn2)

        btn.setOnClickListener {
            val intent = Intent (this@MainActivity,KotlinActivity::class.java)
            startActivity(intent)
        }
    }
}