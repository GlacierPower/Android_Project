package com.example.kollin

import android.content.Intent
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.kollin.SecondActivity.Companion.startSecond

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.setBackgroundDrawable(ColorDrawable(resources.getColor(R.color.grass)))
        supportActionBar?.title =getString(R.string.new_Title)
        supportActionBar?.setIcon(R.drawable.search)

        setContentView(R.layout.activity_main)
        val btnGoTo = findViewById<Button>(R.id.goToSecond)
        val btnClick = findViewById<Button>(R.id.clickMe)
        val textView = findViewById<TextView>(R.id.valhalla)

        btnClick.setOnClickListener{
            textView.text = getString(R.string.hello)
            startSecond(this,
                textView.text.toString()+getString(R.string.fromMain))
        }
        btnGoTo.setOnClickListener{
            startActivity(
                Intent(this,SecondActivity::class.java)
                    .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
                    .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)

//                    .addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY)
            )
            val btnClick = findViewById<Button>(R.id.clickMe)
            val textView = findViewById<TextView>(R.id.valhalla)

            btnClick.setOnClickListener{
                val intent = Intent(this,SecondActivity::class.java)
                startActivity(intent)

                textView.text = "Hello world"
            }
        }
    }
}