package com.gachon.frimo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.bumptech.glide.Glide
import com.gachon.frimo.databinding.ActivityLoadingBinding

class Loading : AppCompatActivity() {
    private lateinit var binding: ActivityLoadingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoadingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Glide.with(this).load(R.raw.loading2).into(binding.loadingSplash)
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this,Login::class.java))
        },6000)
    }
}