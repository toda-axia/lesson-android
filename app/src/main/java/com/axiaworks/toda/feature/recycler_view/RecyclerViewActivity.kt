package com.axiaworks.toda.feature.recycler_view

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.axiaworks.toda.R
import kotlinx.android.synthetic.main.activity_recycler_view.*
import java.util.*

class RecyclerViewActivity : AppCompatActivity() {

    private val dataSet = arrayListOf<String>()

    companion object {
        fun callingIntent(context: Context) = Intent(context, RecyclerViewActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

        initData()
        initRecyclerView()

        vertical_button.setOnClickListener {
            setVerticalRecyclerView()
        }

        horizon_button.setOnClickListener {
            setHorizontalRecyclerView()
        }

        grid_button.setOnClickListener {
            setGridRecyclerView()
        }
    }

    private fun initData() {
        for (i in 1..20) {
            dataSet.add(String.format(Locale.ENGLISH, "Data_0%d", i))
        }
    }

    private fun initRecyclerView() {
        my_recycler_view.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@RecyclerViewActivity)
            adapter = MyAdapter(dataSet)
        }
    }

    private fun setVerticalRecyclerView() {
        my_recycler_view.layoutManager =
            LinearLayoutManager(
                this,
                RecyclerView.VERTICAL,
                false
            )
    }

    private fun setHorizontalRecyclerView() {
        my_recycler_view.layoutManager =
            LinearLayoutManager(
                this,
                RecyclerView.HORIZONTAL,
                false
            )
    }

    private fun setGridRecyclerView() {
        my_recycler_view.layoutManager =
            GridLayoutManager(
                this,
                3,
                RecyclerView.VERTICAL,
                false
            )
    }
}
