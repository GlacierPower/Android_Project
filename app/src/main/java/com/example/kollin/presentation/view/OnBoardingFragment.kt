package com.example.kollin.presentation.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.kollin.R
import com.example.kollin.databinding.FragmentOnBoardingBinding

class OnBoardingFragment : Fragment() {

    private val viewModel: OnBoardingViewModel by viewModels()

    private var _binding: FragmentOnBoardingBinding? = null
    val binding: FragmentOnBoardingBinding get() = _binding!!

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
                parentFragmentManager
                    .beginTransaction()
                    .replace(R.id.activityContainer, ItemsFragment())
                    .commit()
                viewModel.finishPerformed()
            }
        }
    }
}

