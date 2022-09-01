package com.gachon.frimo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.gachon.frimo.R
import com.gachon.frimo.entity.Interest

class SetInterestAdapter(private val dataSet: ArrayList<Interest>) : RecyclerView.Adapter<SetInterestAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val imageview_interest: ImageView
        val textview_interest: TextView

        init {

            // Define click listener for the ViewHolder's View.
            imageview_interest = view.findViewById(R.id.imageview_interest)
            textview_interest = view.findViewById(R.id.textview_interest)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.set_interest_view, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        viewHolder.imageview_interest.setImageResource(dataSet[position].img)
        viewHolder.textview_interest.text = dataSet[position].interest
    }

    override fun getItemCount() = dataSet.size

}
