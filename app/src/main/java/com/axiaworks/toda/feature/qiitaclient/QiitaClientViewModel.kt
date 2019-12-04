package com.axiaworks.toda.feature.qiitaclient

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.axiaworks.toda.feature.retrofit.QiitaService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import org.koin.standalone.KoinComponent
import org.koin.standalone.inject

class QiitaClientViewModel: ViewModel(), KoinComponent {
    private val qiitaService: QiitaService by inject()
    private val disposables = CompositeDisposable()
    val result: MutableLiveData<String> = MutableLiveData()

    override fun onCleared() {
        super.onCleared()

        disposables.clear()
    }

    fun getQiitaArticle(tag: String) {
        qiitaService.getItemsByTag(tag)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { responseBody ->
                    responseBody?.let {
                        val body = it.string()
                        if (body.isNotEmpty()) {
                            result.value = "成功"
                        } else {
                            result.value = "失敗"
                        }
                    }?:run {
                        result.value = "失敗"
                    }
                }, { t ->
                    result.value = "失敗"
                }
            ).also {
                disposables.add(it)
            }
    }
}