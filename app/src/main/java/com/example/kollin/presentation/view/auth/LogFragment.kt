package com.example.kollin.presentation.view.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.kollin.R
import com.example.kollin.databinding.FragmentHomeBinding
import com.example.kollin.databinding.FragmentLogBinding
import com.example.kollin.databinding.FragmentLoginBinding
import com.example.kollin.presentation.view.home.HomeFragment
import com.example.kollin.utils.NavigationOnFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class LogFragment : Fragment(), LoginView {
    private var _binding: FragmentLogBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var loginPresenter: LoginPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLogBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loginPresenter.setView(this)

        binding.login.setOnClickListener {
            loginPresenter.loginUser(
                binding.username.text.toString(),
                binding.password.text.toString()
            )
        }



    }

    override fun userLoggedIn() {
        NavigationOnFragment.replaceFragment(
            parentFragmentManager,
            HomeFragment(),
            false
        )
    }

}