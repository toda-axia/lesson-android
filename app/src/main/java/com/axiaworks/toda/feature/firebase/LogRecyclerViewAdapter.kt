package com.axiaworks.toda.feature.firebase

import androidx.recyclerview.widget.RecyclerView

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.axiaworks.toda.R


class LogRecyclerViewAdapter(myDataSet: ArrayList<String>) : RecyclerView.Adapter<LogRecyclerViewAdapter.ViewHolder>() {

    private var dataSet = arrayListOf<String>()

    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        var mTextView: TextView

        init {
            mTextView = v.findViewById(R.id.log_text) as TextView
        }
    }

    init {
        dataSet = myDataSet
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_log_info, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.mTextView.text = dataSet[position]
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    fun setList(log: String) {
        dataSet.add(log)
        notifyDataSetChanged()
    }
}