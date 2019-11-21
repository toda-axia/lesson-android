package com.axiaworks.toda.feature.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.axiaworks.toda.R

class MyAdapter(myDataSet: ArrayList<String>) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    private var dataSet = arrayListOf<String>()

    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        var mTextView: TextView

        init {
            mTextView = v.findViewById(R.id.text_view) as TextView
        }
    }

    init {
        dataSet = myDataSet
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.my_text_view, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.mTextView.text = dataSet[position]
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }
}