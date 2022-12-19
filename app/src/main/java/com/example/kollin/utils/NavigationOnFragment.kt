package com.example.kollin.utils

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.kollin.R

object NavigationOnFragment {
    fun replaceFragment(
        parentFragmentManager: FragmentManager,
        fragment: Fragment,
        addToBackStack: Boolean
    ) {
        if (addToBackStack) {
            parentFragmentManager
                .beginTransaction()
                .replace(R.id.activityContainer, fragment)
                .addToBackStack(null)
                .commit()
        } else {
            parentFragmentManager
                .beginTransaction()
                .replace(R.id.activityContainer, fragment)
                .commit()
        }
    }
}