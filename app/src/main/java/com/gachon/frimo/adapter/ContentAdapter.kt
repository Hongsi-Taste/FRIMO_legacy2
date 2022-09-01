package com.gachon.frimo.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.gachon.frimo.ContentDetail
import com.gachon.frimo.R
import com.gachon.frimo.entity.Content

class ContentAdapter(private val dataSet: ArrayList<Content>) : RecyclerView.Adapter<ContentAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val imageview_content: ImageView
        val textview_content: TextView
        val textview_date: TextView

        init {

            imageview_content = view.findViewById(R.id.imageview_content)
            textview_content = view.findViewById(R.id.textview_content)
            textview_date = view.findViewById(R.id.textview_date)

            view.setOnClickListener {
                Toast.makeText(it.context, "View Clicked", Toast.LENGTH_SHORT).show()
                it.context.startActivity(Intent(it.context, ContentDetail::class.java))
            }

        }

    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.friendly_community_content_view, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        viewHolder.imageview_content.setImageResource(dataSet[position].contentImage)
        viewHolder.textview_content.text = dataSet[position].contentText
        viewHolder.textview_date.text = dataSet[position].date
    }

    override fun getItemCount() = dataSet.size

}
