package com.gachon.frimo

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.gachon.frimo.adapter.ContentAdapter
import com.gachon.frimo.adapter.FollowAdapter
import com.gachon.frimo.adapter.InterestAdapter
import com.gachon.frimo.databinding.FriendlyCommunityBinding
import com.gachon.frimo.entity.Content
import com.gachon.frimo.entity.Interest
import com.gachon.frimo.entity.UserProfile
import com.skydoves.powermenu.MenuAnimation
import com.skydoves.powermenu.OnMenuItemClickListener
import com.skydoves.powermenu.PowerMenu
import com.skydoves.powermenu.PowerMenuItem

class FriendlyCommunity : AppCompatActivity() {

    private lateinit var menu: PowerMenu
    private lateinit var binding: FriendlyCommunityBinding
    private val interest: ArrayList<Interest> = ArrayList() // Interests
    private val content: ArrayList<Content> = ArrayList() // Contents
    private val follower: ArrayList<UserProfile> = ArrayList() // follower
    private val following: ArrayList<UserProfile> = ArrayList() // following

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding = FriendlyCommunityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 기존 action bar 제거 후 custom action bar 넣기
        supportActionBar!!.hide()

        with(binding) {

            labelInterests.setOnClickListener {

                prepareInterestData()
                interests.setText(interest.size.toString())
                recyclerView.adapter = InterestAdapter(interest)
                recyclerView.layoutManager = GridLayoutManager(it.context, 2)
            }

            labelContents.setOnClickListener {

                prepareContentData()
                contents.setText(content.size.toString())
                recyclerView.adapter = ContentAdapter(content)
                recyclerView.layoutManager = LinearLayoutManager(it.context)
            }

            labelFollowers.setOnClickListener {

                prepareFollowerData()
                followers.setText(follower.size.toString())
                recyclerView.adapter = FollowAdapter(follower)
                recyclerView.layoutManager = LinearLayoutManager(it.context)
            }

            labelFollowings.setOnClickListener {

                prepareFollowingData()
                followings.setText(following.size.toString())
                recyclerView.adapter = FollowAdapter(following)
                recyclerView.layoutManager = LinearLayoutManager(it.context)
            }

        }

        // menu
        menu = PowerMenu.Builder(this)
            .addItem(PowerMenuItem("Change profile", false))
            .addItem(PowerMenuItem("Friend candidate", false))
            .addItem(PowerMenuItem("Add contents", false))
            .setAnimation(MenuAnimation.SHOWUP_TOP_RIGHT) // popup시 menu가 뜨는 위치
            .setTextColor(Color.BLACK)
            .setTextGravity(Gravity.CENTER) // 글자 위치
            .setOnMenuItemClickListener(changeMenuItemClickListener)
            .build()

        // menu icon
        val icon = findViewById<ImageView>(R.id.ic_menu)
        icon.setImageResource(R.drawable.ic_list)

        // menu icon click listener
        icon.setOnClickListener {
            menu.showAsDropDown(it)
        }

    }

    override fun onResume(){
        super.onResume()

        // RecyclerView에 보여 줄 data 받아오기
        prepareInterestData()
        prepareContentData()
        prepareFollowerData()
        prepareFollowingData()

        with(binding) {
            interests.setText(interest.size.toString())
            contents.setText(content.size.toString())
            followers.setText(follower.size.toString())
            followings.setText(following.size.toString())
        }
    }

    // change menu item click listener
    private val changeMenuItemClickListener =
        OnMenuItemClickListener<PowerMenuItem> { position, item ->

            when (position) {
                0 -> startActivity(Intent(this, ModifyProfile::class.java))
                1 -> startActivity(Intent(this, FriendCandidate::class.java))
                2 -> startActivity(Intent(this, AddContents::class.java))
            }
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

    private fun prepareContentData() {

        // Todo: 서버에서 content data 받아오기
        content.clear()
        content.add(Content(R.drawable.img_sample, "test1", "2022-08-13"))
        content.add(Content(R.drawable.img_sample, "test2", "2022-08-13"))
        content.add(Content(R.drawable.img_sample, "test3", "2022-08-13"))
        content.add(Content(R.drawable.img_sample, "test4", "2022-08-13"))
        content.add(Content(R.drawable.img_sample, "test5", "2022-08-13"))
        content.add(Content(R.drawable.img_sample, "test6", "2022-08-13"))
        content.add(Content(R.drawable.img_sample, "test7", "2022-08-13"))
        content.add(Content(R.drawable.img_sample, "test8", "2022-08-13"))
    }

    private fun prepareFollowerData() {

        // Todo: 서버에서 follower data 받아오기
        follower.clear()
        follower.add(UserProfile(R.drawable.ic_user, "test1", "test1 description"))
        follower.add(UserProfile(R.drawable.ic_user, "test2", "test2 description"))
        follower.add(UserProfile(R.drawable.ic_user, "test3", "test3 description"))
        follower.add(UserProfile(R.drawable.ic_user, "test4", "test4 description"))
        follower.add(UserProfile(R.drawable.ic_user, "test5", "test5 description"))
        follower.add(UserProfile(R.drawable.ic_user, "test6", "test6 description"))
        follower.add(UserProfile(R.drawable.ic_user, "test7", "test7 description"))
        follower.add(UserProfile(R.drawable.ic_user, "test8", "test8 description"))
        follower.add(UserProfile(R.drawable.ic_user, "test9", "test9 description"))
        follower.add(UserProfile(R.drawable.ic_user, "test10", "test10 description"))
    }

    private fun prepareFollowingData() {

        // Todo: 서버에서 following data 받아오기
        following.clear()
        following.add(UserProfile(R.drawable.img_sample, "test1", "test1 description"))
        following.add(UserProfile(R.drawable.img_sample, "test2", "test2 description"))
        following.add(UserProfile(R.drawable.img_sample, "test3", "test3 description"))
        following.add(UserProfile(R.drawable.img_sample, "test4", "test4 description"))
        following.add(UserProfile(R.drawable.img_sample, "test5", "test5 description"))
        following.add(UserProfile(R.drawable.img_sample, "test6", "test6 description"))
        following.add(UserProfile(R.drawable.img_sample, "test7", "test7 description"))
        following.add(UserProfile(R.drawable.img_sample, "test8", "test8 description"))
        following.add(UserProfile(R.drawable.img_sample, "test9", "test9 description"))
        following.add(UserProfile(R.drawable.img_sample, "test10", "test10 description"))
        following.add(UserProfile(R.drawable.img_sample, "test11", "test11 description"))
        following.add(UserProfile(R.drawable.img_sample, "test12", "test12 description"))
        following.add(UserProfile(R.drawable.img_sample, "test13", "test13 description"))
        following.add(UserProfile(R.drawable.img_sample, "test14", "test14 description"))
    }

}