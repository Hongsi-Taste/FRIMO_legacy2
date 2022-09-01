package com.gachon.frimo

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gachon.frimo.databinding.TermsOfUseBinding

class TermsOfUse : AppCompatActivity() {

    private lateinit var binding: TermsOfUseBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding = TermsOfUseBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonContinue.setOnClickListener {
            startActivity(Intent(this, SignUp::class.java))
        }


    }
}