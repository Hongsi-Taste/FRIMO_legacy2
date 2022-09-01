package com.gachon.frimo

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.gachon.frimo.databinding.ModifyProfileBinding

class ModifyProfile : AppCompatActivity() {

    private lateinit var binding: ModifyProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding = ModifyProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 기존 action bar 제거 후 custom action bar 넣기
        supportActionBar!!.hide()

        // menu
        val icon = findViewById<ImageView>(R.id.ic_menu)
        icon.setImageResource(R.drawable.ic_check)
        icon.setOnClickListener {
            startActivity(Intent(this, FriendlyCommunity::class.java))
        }

        binding.buttonSetInterest.setOnClickListener {
            startActivity(Intent(this, SetInterest::class.java))
        }

    }
}