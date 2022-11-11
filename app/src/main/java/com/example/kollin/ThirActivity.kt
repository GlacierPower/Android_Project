package com.example.kollin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.kollin.R

class ThirActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_thir)

        val btnGoTo = findViewById<Button>(R.id.goToFFirst)
        btnGoTo.setOnClickListener {
            startActivity(
                Intent("com.example.kollin.OPEN_FIRST_ACTIVITY")
            )
        }
    }
}