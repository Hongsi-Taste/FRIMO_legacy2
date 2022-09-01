package com.gachon.frimo

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.gachon.frimo.adapter.AddContentAdapter
import com.gachon.frimo.databinding.AddContentsBinding
import com.skydoves.balloon.Balloon
import com.skydoves.balloon.BalloonAnimation
import com.skydoves.balloon.IconGravity

class AddContents : AppCompatActivity() {

    private lateinit var binding: AddContentsBinding
    private val contents: ArrayList<Int> = ArrayList() // Contents

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding = AddContentsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar!!.hide() // 기존 action bar 제거 후 custom action bar 넣기

        val balloon = Balloon.Builder(this)
            .setText("Want to import images from Gallery?") // 보여줄 Text
            .setTextSize(15f) // Text size
            .setPadding(10) // Text와 테두리 사이의 간격 설정
            .setArrowPosition(0.88f) // Arrow 위치
            .setIconGravity(IconGravity.START) // Icon 위치 설정
            .setDismissWhenClicked(false) // userBalloon이 뜨고 Balloon을 클릭 시 dismiss 할지 여부
            .setBalloonAnimation(BalloonAnimation.CIRCULAR) // Balloon animation
            .setBackgroundColor(ContextCompat.getColor(this, R.color.black)) // Background color 설정
            .build()

        val icon = findViewById<ImageView>(R.id.ic_menu)
        icon.setImageResource(R.drawable.ic_plus)
        icon.setOnClickListener {
            balloon.showAlignBottom(icon)
        }

        balloon.setOnBalloonClickListener {

            balloon.dismiss()
            Toast.makeText(this, "Gallary로 이동해서 이미지 가져오기", Toast.LENGTH_SHORT).show()
            // Todo: Gallary에서 이미지 가져오기
        }

        binding.buttonPost.setOnClickListener {

            // Todo: 서버에 올리기
            startActivity(Intent(this, FriendlyCommunity::class.java))
        }

        // RecyclerView 셋팅
        prepareData() // Todo: Gallary에서 이미지 가져오는 것이 구현되면 지우기
        binding.AddContentRecyclerView.adapter = AddContentAdapter(contents)

    }

    private fun prepareData() {

        contents.add(R.drawable.img_sample)
        contents.add(R.drawable.img_sample)
        contents.add(R.drawable.img_sample)
        contents.add(R.drawable.img_sample)
        contents.add(R.drawable.img_sample)

    }
}