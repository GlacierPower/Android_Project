package com.example.kollin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

class OnBoardingFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_on_boarding, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val onBoardingFinished = view.findViewById<Button>(R.id.btnFinish)
        onBoardingFinished.setOnClickListener {
            parentFragmentManager
                .beginTransaction()
                .replace(R.id.activityContainer,ItemsFragment())
                .commit()
        }
    }
}
