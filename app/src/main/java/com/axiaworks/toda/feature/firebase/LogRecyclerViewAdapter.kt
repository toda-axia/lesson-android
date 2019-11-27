package com.axiaworks.toda.feature.firebase

import androidx.recyclerview.widget.RecyclerView

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.axiaworks.toda.R

class LogRecyclerViewAdapter(
    private var dataSet: ArrayList<String>
) : RecyclerView.Adapter<LogRecyclerViewAdapter.ViewHolder>() {

    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        var mTextView: TextView = v.findViewById(R.id.log_text)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.list_item_log_info, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.mTextView.text = dataSet[position]
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    fun setList(logList: ArrayList<String>) {
        dataSet = logList
        notifyDataSetChanged()
    }
}