package com.gachon.frimo.diary

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContentProviderCompat
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gachon.frimo.R


class myDiaryChat : Fragment() {
    companion object{
        fun newInstance() : myDiaryChat {
            return myDiaryChat()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_my_diary_chat,container,false)
        val recyclerView = view.findViewById<RecyclerView>(R.id.chatRecycler)
        //recyclerView.layoutManager = LinearLayoutManager(ContentProviderCompat.requireContext())
        //recyclerView.adapter = RecyclerViewAdaper()
        // Inflate the layout for this fragment
        return view
    }
}