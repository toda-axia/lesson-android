package com.axiaworks.toda.feature.qiitaclient

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import com.axiaworks.toda.R
import com.axiaworks.toda.databinding.FragmentQiitaContentDialogBinding
import com.axiaworks.toda.feature.retrofit.QiitaService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.sharedViewModel

class QiitaContentDialogFragment: DialogFragment() {
    private val qiitaClientViewModel: QiitaClientViewModel by sharedViewModel()
    private val disposables = CompositeDisposable()
    private val qiitaService: QiitaService by inject()
    private lateinit var binding: FragmentQiitaContentDialogBinding

    companion object {
        const val TAG = "QiitaContentDialogFragment"
    }

    override fun onResume() {
        super.onResume()
        getQiitaContent(qiitaClientViewModel.qiitaId.value!!)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(activity)
        binding = DataBindingUtil.inflate(
            LayoutInflater.from(context),
            R.layout.fragment_qiita_content_dialog,
            null,
            false)
        val view = binding.root
        builder.setView(view)
        return builder.create()
    }

    private fun getQiitaContent(itemId: String) {
        qiitaService.getArticleByItemId(itemId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    it.let { qiitaInfo ->
                        binding.qiitacontent = qiitaInfo
                    }
                }, { t ->
                }
            ).also {
                disposables.add(it)
            }
    }
}