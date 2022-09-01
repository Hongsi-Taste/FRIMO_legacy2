package com.gachon.frimo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gachon.frimo.adapter.FriendCandidateAdapter
import com.gachon.frimo.databinding.FriendCandidateBinding
import com.gachon.frimo.entity.UserProfile

class FriendCandidate : AppCompatActivity() {

    private lateinit var binding: FriendCandidateBinding
    private val user: ArrayList<UserProfile> = ArrayList() // User

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding = FriendCandidateBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // RecyclerView 셋팅
        prepareData(); // RecyclerView에 보여 줄 Report 받아오기
        binding.FriendCandidateRecyclerView.adapter = FriendCandidateAdapter(user)
    }

    private fun prepareData() {

        // Todo: 서버랑 연결해 User data 받아오기
        user.add(UserProfile(R.drawable.img_sample, "test1", "test1 description"))
        user.add(UserProfile(R.drawable.img_sample, "test2", "test2 description"))
        user.add(UserProfile(R.drawable.img_sample, "test3", "test3 description"))
        user.add(UserProfile(R.drawable.img_sample, "test4", "test4 description"))
        user.add(UserProfile(R.drawable.img_sample, "test5", "test5 description"))

    }

}