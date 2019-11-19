package com.axiaworks.toda.feature.recycler_view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.axiaworks.toda.R

class MyAdapter(myDataset: ArrayList<String>) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    private var dataset = arrayListOf<String>()

    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        var mTextView: TextView

        init {
            mTextView = v.findViewById(R.id.text_view) as TextView
        }
    }

    init {
        dataset = myDataset
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.my_text_view, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.mTextView.text = dataset[position]
    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}