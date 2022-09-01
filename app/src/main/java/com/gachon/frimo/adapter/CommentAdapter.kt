package com.gachon.frimo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.gachon.frimo.R
import com.gachon.frimo.entity.Comment

class CommentAdapter(private val dataSet: ArrayList<Comment>) : RecyclerView.Adapter<CommentAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val imageview_userProfile: ImageView
        val textview_userName: TextView
        val textview_comment: TextView

        init {

            imageview_userProfile = view.findViewById(R.id.imageview_userProfile)
            textview_userName = view.findViewById(R.id.textview_userName)
            textview_comment = view.findViewById(R.id.textview_comment)
        }

    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.content_detail_comment, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        viewHolder.imageview_userProfile.setImageResource(dataSet[position].profileImage)
        viewHolder.textview_userName.text = dataSet[position].name
        viewHolder.textview_comment.text = dataSet[position].comment
    }

    override fun getItemCount() = dataSet.size

}
