package com.gachon.frimo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.gachon.frimo.entity.Report
import com.gachon.frimo.adapter.TrendReportAdapter
import com.gachon.frimo.databinding.TrendReportBinding

class TrendReport : AppCompatActivity(){

    private val reports: ArrayList<Report> = ArrayList() // Report
    private lateinit var binding: TrendReportBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding = TrendReportBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // RecyclerView 셋팅
        prepareData(); // RecyclerView에 보여 줄 data 받아오기
        binding.TrendReportRecyclerView.adapter = TrendReportAdapter(reports)

    }

    private fun prepareData() {

        // Todo: 크롤링으로 data 받아오기
        reports.add(Report(R.drawable.img_sample, "test1"))
        reports.add(Report(R.drawable.img_sample, "test2"))
        reports.add(Report(R.drawable.img_sample, "test3"))
        reports.add(Report(R.drawable.img_sample, "test4"))
        reports.add(Report(R.drawable.img_sample, "test5"))

    }
}