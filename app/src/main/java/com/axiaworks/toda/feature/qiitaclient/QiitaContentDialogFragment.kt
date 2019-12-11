package com.axiaworks.toda.feature.qiitaclient

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.databinding.DataBindingUtil.bind
import androidx.databinding.DataBindingUtil.setContentView
import androidx.fragment.app.DialogFragment
import com.axiaworks.toda.R
import com.axiaworks.toda.databinding.FragmentQiitaContentDialogBinding
import com.axiaworks.toda.feature.retrofit.QiitaService
import io.noties.markwon.Markwon
import io.noties.markwon.SpannableBuilder
import io.noties.markwon.image.ImagesPlugin
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_qiita_content_dialog.*
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

//    private fun getQiitaContent(itemId: String) {
//        qiitaService.getArticleByItemId(itemId)
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe(
//                {
//                    it.let { qiitaInfo ->
//                        binding.qiitacontent = qiitaInfo
//                        val markwon = Markwon.create(requireContext())
//                        binding.qiitacontent.body = markwon.toMarkdown(binding.qiitacontent.body)?.toString()
//                    }
//                }, { t ->
//                }
//            ).also {
//                disposables.add(it)
//            }
//    }

    private fun getQiitaContent(itemId: String) {
        qiitaService.getArticleByItemId(itemId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    it.let { qiitaInfo ->
                        binding.qiitaTitleText.text = qiitaInfo.title
                        val markwon = Markwon.create(requireContext())
//                        val markwon = Markwon.builder(requireContext()).usePlugin(ImagesPlugin.create())
                        markwon.setMarkdown(binding.qiitaContentText, qiitaInfo.body)
                    }
                }, { t ->
                }
            ).also {
                disposables.add(it)
            }
    }
}