package com.axiaworks.toda.feature.dialog_fragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.axiaworks.toda.R

var dialogLogDataSet = arrayListOf<String>()

class DialogLogAdapter(myDataSet: ArrayList<String>) : RecyclerView.Adapter<DialogLogAdapter.ViewHolder>() {

    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        var mTextView: TextView

        init {
            mTextView = v.findViewById(R.id.dialog_log_text) as TextView
        }
    }

    init {
        dialogLogDataSet = myDataSet
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_dialog_log_info, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.mTextView.text = dialogLogDataSet[position]
    }

    override fun getItemCount(): Int {
        return dialogLogDataSet.size
    }

    fun setList(dialogLogList: ArrayList<String>) {
        dialogLogDataSet = dialogLogList
        notifyDataSetChanged()
    }
}