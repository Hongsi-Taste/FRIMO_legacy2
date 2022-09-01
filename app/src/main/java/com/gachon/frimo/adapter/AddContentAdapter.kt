package com.gachon.frimo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.gachon.frimo.R

class AddContentAdapter(private val dataSet: ArrayList<Int>) : RecyclerView.Adapter<AddContentAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val imageview_photo: ImageView

        init {

            imageview_photo = view.findViewById(R.id.imageview_photo)

            // Todo: 이미지 클릭 시 삭제
            view.setOnClickListener {
                Toast.makeText(it.context, "Todo: Delete Image", Toast.LENGTH_SHORT).show()
            }

        }

    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.add_contents_view, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        viewHolder.imageview_photo.setImageResource(dataSet[position])
    }

    override fun getItemCount() = dataSet.size

}
