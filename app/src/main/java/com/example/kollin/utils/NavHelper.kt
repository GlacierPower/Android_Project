package com.example.kollin.utils


import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.example.kollin.R

object NavHelper {


    fun Fragment.navigate(destinationID: Int) {
        findNavController().navigate(destinationID)
    }

    fun Fragment.replaceGraph(graphID: Int) {
        findNavController().setGraph(graphID)
    }

    fun Fragment.navigateWithDeletedBackStack(destinationID: Int, fragmentToRemove: Int) {
        val navOptions = NavOptions.Builder()
        navOptions.setPopUpTo(fragmentToRemove, true)
        findNavController().navigate(
            destinationID,
            null,
            navOptions.build()
        )
    }

    fun Fragment.navigateWithBundle(destinationID: Int, bundle: Bundle) {
        findNavController().navigate(destinationID, bundle)
    }
}