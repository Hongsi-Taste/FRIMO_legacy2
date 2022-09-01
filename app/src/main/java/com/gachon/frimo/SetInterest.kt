package com.gachon.frimo

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.gachon.frimo.adapter.AddContentAdapter
import com.gachon.frimo.adapter.SetInterestAdapter
import com.gachon.frimo.databinding.SetInterestBinding
import com.gachon.frimo.entity.Interest

class SetInterest : AppCompatActivity() {

    private lateinit var binding: SetInterestBinding
    private val interest: ArrayList<Interest> = ArrayList() // Interests

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding = SetInterestBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar!!.hide() // 기존 action bar 제거 후 custom action bar 넣기

        // menu
        val icon = findViewById<ImageView>(R.id.ic_menu)
        icon.setImageResource(R.drawable.ic_check)
        icon.setOnClickListener {

            // Todo: Interest 서버에 저장
            startActivity(Intent(this, FriendlyCommunity::class.java))
        }

        // Setting RecyclerView
        prepareInterestData()
        binding.setInterestRecyclerView.adapter = SetInterestAdapter(interest)

    }

    private fun prepareInterestData() {

        // Todo: 서버에서 interest data 받아오기
        interest.clear()
        interest.add(Interest(R.drawable.img_sample, "test1"))
        interest.add(Interest(R.drawable.img_sample, "test2"))
        interest.add(Interest(R.drawable.img_sample, "test3"))
        interest.add(Interest(R.drawable.img_sample, "test4"))
        interest.add(Interest(R.drawable.img_sample, "test5"))
        interest.add(Interest(R.drawable.img_sample, "test6"))
        interest.add(Interest(R.drawable.img_sample, "test7"))
        interest.add(Interest(R.drawable.img_sample, "test8"))
        interest.add(Interest(R.drawable.img_sample, "test9"))
        interest.add(Interest(R.drawable.img_sample, "test10"))
    }
}