package com.axiaworks.toda.feature.qiitaclient

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.axiaworks.toda.R
import com.axiaworks.toda.feature.retrofit.QiitaClient
import com.axiaworks.toda.feature.retrofit.QiitaService
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.plugins.RxJavaPlugins
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_article.*
import kotlinx.android.synthetic.main.fragment_qiita_content_dialog.*
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.sharedViewModel
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.standalone.inject

class QiitaContentDialogFragment: DialogFragment() {
    private val qiitaClientViewModel: QiitaClientViewModel by sharedViewModel()
    private val disposables = CompositeDisposable()
    private val qiitaService: QiitaService by inject()

    companion object {
        const val TAG = "QiitaContentDialogFragment"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        Log.d("QiitaContentDialog1", qiitaClientViewModel.qiitaId.value!!)
        getQiitaContent(qiitaClientViewModel.qiitaId.value!!)
        val qiitaContentDialog = View.inflate(context, R.layout.fragment_qiita_content_dialog, null)

        return AlertDialog.Builder(requireContext())
            .apply {
                setView(qiitaContentDialog)
            }.create()
    }

    private fun getQiitaContent(itemId: String) {
        qiitaService.getArticleByItemId(itemId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { list ->
                    list?.body.let {
                        Log.d("QiitaContentDialog2", it)
                        qiita_content_text.text = it
                    }
                }, { t ->
                }
            ).also {
                disposables.add(it)
            }
    }
}