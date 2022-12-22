package com.example.kollin.presentation.view.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.kollin.databinding.FragmentOnBoardingBinding
import com.example.kollin.presentation.view.home.ItemsFragment
import com.example.kollin.utils.NavigationOnFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class OnBoardingFragment : Fragment(), OnBoardingView {

    private var _binding: FragmentOnBoardingBinding? = null
    private val binding: FragmentOnBoardingBinding get() = _binding!!

    @Inject
    lateinit var onBoardingPresenter: OnBoardingPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOnBoardingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        onBoardingPresenter.setView(this)

        binding.btnFinish.setOnClickListener {
            onBoardingPresenter.goToItemsFragment()
        }

    }

    override fun goToItemsFragment() {
        NavigationOnFragment.replaceFragment(
            parentFragmentManager,
            ItemsFragment(),
            false
        )
    }
}


