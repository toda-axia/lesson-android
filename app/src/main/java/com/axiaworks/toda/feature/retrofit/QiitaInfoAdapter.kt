package com.axiaworks.toda.feature.retrofit

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.axiaworks.toda.R
import kotlinx.android.synthetic.main.list_item_qiita_info.view.*

class QiitaInfoAdapter(private val context: Context,
                       private val qiitaInfoList: List<QiitaInfo>) : RecyclerView.Adapter<QiitaInfoAdapter.QiitaInfoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QiitaInfoViewHolder {
        val layoutInflater = LayoutInflater.from(context)
        val qiitaTitleView = layoutInflater.inflate(R.layout.list_item_qiita_info, parent, false)

        return QiitaInfoViewHolder(qiitaTitleView)
    }

    override fun getItemCount(): Int {
        return qiitaInfoList.size
    }

    override fun onBindViewHolder(holder: QiitaInfoViewHolder, position: Int) {
        holder.let {
            it.qiitaTitle.text = "${qiitaInfoList[position].title}"
        }
    }

    inner class QiitaInfoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val qiitaTitle: TextView = view.qiita_title_text
    }
}