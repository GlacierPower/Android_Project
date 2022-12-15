package com.example.kollin.presentation.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kollin.R
import com.example.kollin.presentation.view.data_binding.LoginFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentTransaction  = supportFragmentManager
            .beginTransaction()
        fragmentTransaction.add(R.id.activityContainer, LoginFragment())
        fragmentTransaction.commit()

    }
}