package com.gachon.frimo.diary

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.gachon.frimo.R

/**
 * A simple [Fragment] subclass.
 * Use the [myDiarySecret.newInstance] factory method to
 * create an instance of this fragment.
 */
class myDiarySecret : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_diary_secret, container, false)
    }

    companion object {

        fun newInstance(param1: String, param2: String) =
            myDiarySecret().apply {
                arguments = Bundle().apply {

                }
            }
    }
}