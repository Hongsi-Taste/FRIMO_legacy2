package com.gachon.frimo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.gachon.frimo.R
import com.gachon.frimo.entity.UserProfile
import com.skydoves.balloon.Balloon;
import com.skydoves.balloon.BalloonAnimation;
import com.skydoves.balloon.IconGravity;

class FollowAdapter(private val dataSet: ArrayList<UserProfile>) : RecyclerView.Adapter<FollowAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val imageview_userProfile: ImageView
        val textview_userName: TextView
        val textview_userDesc: TextView

        // UserBalloon
        val userBalloon = Balloon.Builder(view.context)
            .setText("Click to see where this user lives") // 보여줄 Text
            .setTextSize(15f) // Text size
            .setPadding(10) // Text와 테두리 사이의 간격 설정
            .setIconDrawableResource(R.drawable.ic_gps) // GPS Icon
            .setIconGravity(IconGravity.START) // Icon 위치 설정
            .setDismissWhenClicked(false) // userBalloon이 뜨고 Balloon을 클릭 시 dismiss 할지 여부
            .setBalloonAnimation(BalloonAnimation.CIRCULAR) // Balloon animation
            .setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.black)) // Background color 설정
            .build()

        init {

            imageview_userProfile = view.findViewById(R.id.imageview_follow)
            textview_userName = view.findViewById(R.id.textview_follow_name)
            textview_userDesc = view.findViewById(R.id.textview_follow_desc)

            view.setOnClickListener(userBalloon::showAlignBottom)

            userBalloon.setOnBalloonClickListener {
                Toast.makeText(it.context, "Balloon clicked", Toast.LENGTH_SHORT).show()
            }
        }

    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.friendly_community_follow_view, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        viewHolder.imageview_userProfile.setImageResource(dataSet[position].profileImage)
        viewHolder.textview_userName.text = dataSet[position].name
        viewHolder.textview_userDesc.text = dataSet[position].desc
    }

    override fun getItemCount() = dataSet.size

}
