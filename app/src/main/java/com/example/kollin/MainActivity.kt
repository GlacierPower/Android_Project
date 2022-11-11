package com.example.kollin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnGoTo = findViewById<Button>(R.id.goToSecond)
        btnGoTo.setOnClickListener{
            startActivity(
                Intent(this,SecondActivity::class.java)
                    .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
                    .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)

//                    .addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY)
            )
        }
    }
}