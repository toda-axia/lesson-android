package com.axiaworks.toda.feature.qiitaclient

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import com.axiaworks.toda.R
import com.axiaworks.toda.databinding.ListItemQiitaInfoBinding
import com.axiaworks.toda.feature.dialog_fragment.DialogFragmentFragment
import org.koin.java.standalone.KoinJavaComponent.inject


class QiitaClientAdapter(private val context: Context,
                       private val qiitaInfoList: List<QiitaInfo>,
                         private val viewModel: QiitaClientViewModel) : RecyclerView.Adapter<QiitaClientAdapter.QiitaInfoViewHolder>() {

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

        holder.itemView.setOnClickListener {
            viewModel.tapItems(position)
        }
    }

    inner class QiitaInfoViewHolder(var binding: ListItemQiitaInfoBinding) : RecyclerView.ViewHolder(binding.root)
}