package com.example.kollin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val btnGoTo = findViewById<Button>(R.id.goToThird)
        btnGoTo.setOnClickListener {
            startActivity(
                Intent(this,ThirActivity::class.java)
            )
        }
    }
}