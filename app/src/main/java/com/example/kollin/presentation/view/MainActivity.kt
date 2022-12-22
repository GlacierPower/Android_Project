package com.example.kollin.presentation.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.kollin.R
import com.example.kollin.databinding.ActivityMainBinding
import com.example.kollin.presentation.view.auth.LogFragment
import com.example.kollin.presentation.view.home.HomeFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), MainView {

    private var _binding: ActivityMainBinding? = null

    @Inject
    lateinit var mainActivityPresenter: MainActivityPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(_binding!!.root)

        mainActivityPresenter.setView(this)

        mainActivityPresenter.checkUserExists()

    }

    override fun userExistsResult(userExists: Boolean) {
        val fragmentTransaction = supportFragmentManager
            .beginTransaction()
        fragmentTransaction.add(
            R.id.activityContainer,
            when (userExists) {
                true -> HomeFragment()
                false -> LogFragment()
            }
        )
        fragmentTransaction.commit()
    }

}
