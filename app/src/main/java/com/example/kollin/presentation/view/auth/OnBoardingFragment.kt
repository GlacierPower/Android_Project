package com.example.kollin.presentation.view.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.MutableLiveData
import com.example.kollin.databinding.FragmentOnBoardingBinding
import com.example.kollin.presentation.view.home.ItemsFragment
import com.example.kollin.utils.NavigationOnFragment

class OnBoardingFragment : Fragment()  {

    private val viewModel: OnBoardingViewModel by viewModels()

    private var _binding: FragmentOnBoardingBinding? = null
    private val binding: FragmentOnBoardingBinding get() = _binding!!

    val onBoardingText = MutableLiveData<String>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOnBoardingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        viewModel.nav.observe(viewLifecycleOwner) {
            if (it != null) {
                NavigationOnFragment.replaceFragment(
                    parentFragmentManager,
                    ItemsFragment(),
                    false
                )
                viewModel.finishPerformed()
            }
        }
    }
}

