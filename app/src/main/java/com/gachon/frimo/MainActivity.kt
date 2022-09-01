package com.gachon.frimo

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.gachon.frimo.databinding.ActivityMainBinding
import com.gachon.frimo.diary.MyDiary

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        //권한 임시
        permissions()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //FloatingActionButton
        binding.floatingMyDiary.setOnClickListener{
            startActivity(Intent(this, MyDiary::class.java))
        }
        binding.floatingFriendlyCommunity.setOnClickListener{
            startActivity(Intent(this, FriendlyCommunity::class.java))
        }
        binding.floatingTrendReport.setOnClickListener{
            startActivity(Intent(this, TrendReport::class.java))
        }
        binding.floatingBtn4.setOnClickListener{
            startActivity(Intent(this, MapTest::class.java))
        }
    }

    private fun permissions() {
        if (Build.VERSION.SDK_INT >= 23 && ContextCompat.checkSelfPermission(
                this, Manifest.permission.RECORD_AUDIO
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.RECORD_AUDIO),1)
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.INTERNET),1)
        }
    }
}