package com.example.kollin.presentation.view.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.kollin.databinding.FragmentHomeBinding
import com.example.kollin.presentation.view.auth.OnBoardingFragment
import com.example.kollin.utils.NavigationOnFragment.replaceFragment
import com.example.kollin.utils.coroutines.CoroutinesExample
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.*

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val viewModel: HomeViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        viewModel.showUserData()

        CoroutinesExample().testCoroutineCancel()

        binding.btnOnBoarding.setOnClickListener {
            replaceFragment(
                parentFragmentManager,
                OnBoardingFragment(),
                false
            )
        }







        viewModel.userCreds.observe(viewLifecycleOwner) {
            binding.textCreds.text = "${it.userName}\n${it.userPassword}"
        }

    }
}