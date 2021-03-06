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
import com.bumptech.glide.Glide
import io.noties.markwon.Markwon
import io.noties.markwon.ext.tables.TablePlugin
import io.noties.markwon.image.glide.GlideImagesPlugin
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.sharedViewModel

class QiitaContentDialogFragment: DialogFragment() {
    private val qiitaClientViewModel: QiitaClientViewModel by sharedViewModel()
    private val disposables = CompositeDisposable()
    private val qiitaService: QiitaClientService by inject()
    private lateinit var binding: FragmentQiitaContentDialogBinding

    companion object {
        private const val TAG = "QiitaContentDialog"
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
            false
        )
        return builder.setView(binding.root).create()
    }

    private fun getQiitaContent(itemId: String) {
        qiitaService.getArticleByItemId(itemId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    it.let { qiitaInfo ->
                        binding.qiitaTitleText.text = qiitaInfo.title
                        Markwon.builder(requireContext())
                            .usePlugin(TablePlugin.create(requireContext()))
                            .usePlugin(GlideImagesPlugin.create(Glide.with(requireContext())))
                            .build()
                            .setMarkdown(binding.qiitaContentText, qiitaInfo.body)
                    }
                }, { t ->
                    Log.w(TAG, t)
                }
            ).also {
                disposables.add(it)
            }
    }
}