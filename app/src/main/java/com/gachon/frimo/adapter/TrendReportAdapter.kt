package com.gachon.frimo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.gachon.frimo.R
import com.gachon.frimo.entity.Report

class TrendReportAdapter(private val dataSet: ArrayList<Report>) : RecyclerView.Adapter<TrendReportAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val textView: TextView
        val imageView: ImageView

        init {

            // Define click listener for the ViewHolder's View.
            textView = view.findViewById(R.id.textView_report)
            imageView = view.findViewById(R.id.imageview_report)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.trend_report_view, viewGroup, false)
        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.imageView.setImageResource(dataSet[position].img)
        viewHolder.textView.text = dataSet[position].content
    }

    override fun getItemCount() = dataSet.size

}
