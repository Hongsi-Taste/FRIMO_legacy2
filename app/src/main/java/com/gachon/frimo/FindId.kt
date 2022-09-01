package com.gachon.frimo

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.gachon.frimo.databinding.FindIdBinding
import com.skydoves.powermenu.MenuAnimation
import com.skydoves.powermenu.OnMenuItemClickListener
import com.skydoves.powermenu.PowerMenu
import com.skydoves.powermenu.PowerMenuItem

class FindId : AppCompatActivity() {

    private lateinit var menu: PowerMenu
    private lateinit var binding: FindIdBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding = FindIdBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 기존 action bar 제거 후 custom action bar 넣기
        supportActionBar!!.hide()

        // set menu icon
        val icon = findViewById<ImageView>(R.id.ic_menu)
        icon.setImageResource(R.drawable.ic_list)

        // menu icon click listener
        icon.setOnClickListener { view ->
            menu.showAsDropDown(view)
        }

        menu = PowerMenu.Builder(this)
            .addItem(PowerMenuItem("Find Id", true))
            .addItem(PowerMenuItem("Find Pw", false))
            .setAnimation(MenuAnimation.SHOWUP_TOP_RIGHT) // popup시 menu가 뜨는 위치
            .setTextColor(Color.BLACK)
            .setTextGravity(Gravity.CENTER) // 글자 위치
            .setSelectedMenuColor(getResources().getColor(R.color.purple_200))
            .setSelectedTextColor(Color.WHITE)
            .setOnMenuItemClickListener(changeMenuItemClickListener)
            .build()

        binding.buttonFindId.setOnClickListener {
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
            finish()
        }

    }

    // change menu item click listener
    private val changeMenuItemClickListener =
        OnMenuItemClickListener<PowerMenuItem> { position, item ->

            when (position) {
                1 -> startActivity(Intent(this, FindPw::class.java))
            }
        }
}