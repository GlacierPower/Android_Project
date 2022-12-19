package com.example.kollin.presentation.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.viewModels
import com.example.kollin.R
import com.example.kollin.databinding.ActivityMainBinding
import com.example.kollin.presentation.view.auth.LogFragment
import com.example.kollin.presentation.view.home.HomeFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(_binding!!.root)

        viewModel.checkExists()
        viewModel.userExists.observe(this){
            val fragmentTransaction = supportFragmentManager
                .beginTransaction()
            fragmentTransaction.add(R.id.activityContainer,
                when(it){
                    true->HomeFragment()
                    false->LogFragment()
                }
            )
            fragmentTransaction.commit()
        }

    }
}