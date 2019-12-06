package com.axiaworks.toda.feature.qiitaclient

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.axiaworks.toda.databinding.ListItemQiitaInfoBinding


class QiitaClientAdapter(private val context: Context,
                       private val qiitaInfoList: List<QiitaInfo>) : RecyclerView.Adapter<QiitaClientAdapter.QiitaInfoViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QiitaInfoViewHolder {
        val layoutInflater = LayoutInflater.from(context)

        val binding = ListItemQiitaInfoBinding.inflate(layoutInflater, parent, false)
        return QiitaInfoViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return qiitaInfoList.size
    }

    override fun onBindViewHolder(holder: QiitaInfoViewHolder, position: Int) {
        val data = qiitaInfoList[position]
        holder.binding.qiitainfo = data
    }

    inner class QiitaInfoViewHolder(var binding: ListItemQiitaInfoBinding) : RecyclerView.ViewHolder(binding.root)
}