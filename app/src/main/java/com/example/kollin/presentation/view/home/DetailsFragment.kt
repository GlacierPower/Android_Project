package com.example.kollin.presentation.view.home


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.kollin.databinding.FragmentDetailsBinding
import com.example.kollin.presentation.view.auth.LogFragment
import com.example.kollin.presentation.view.home.ItemsFragment.Companion.NAME
import com.example.kollin.utils.BundleConstance.DATE
import com.example.kollin.utils.BundleConstance.IMAGE_VIEW
import com.example.kollin.utils.NavigationOnFragment.replaceFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class DetailsFragment : Fragment(), DetailsView {

    private var _viewBinding: FragmentDetailsBinding? = null
    private val viewBinding get() = _viewBinding!!

    @Inject
    lateinit var detailsPresenter: DetailsPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _viewBinding = FragmentDetailsBinding.inflate(inflater)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        detailsPresenter.setView(this)

        val bundle = arguments
        bundle?.let { safeBundle ->
            detailsPresenter.getArguments(
                safeBundle.getString(NAME),
                safeBundle.getString(DATE),
                safeBundle.getInt(IMAGE_VIEW)
            )
        }


        viewBinding.btnLogOut.setOnClickListener {
            detailsPresenter.logoutUser()
        }


    }

    override fun userLoggedOut() {
        replaceFragment(
            parentFragmentManager,
            LogFragment(),
            false
        )
    }


    override fun displayItemData(name: String, date: String, imageView: Int) {

        viewBinding.detailsName.text = name
        viewBinding.detailsDate.text = date
        viewBinding.detailsImage.setBackgroundResource(imageView)

    }
}