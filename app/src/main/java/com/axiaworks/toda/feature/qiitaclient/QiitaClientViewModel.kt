package com.axiaworks.toda.feature.qiitaclient

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import com.axiaworks.toda.feature.retrofit.QiitaService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_article.*
import org.koin.standalone.KoinComponent
import org.koin.standalone.inject

class QiitaClientViewModel: ViewModel(), KoinComponent {
    private val qiitaService: QiitaService by inject()
    private val disposables = CompositeDisposable()
    val result: MutableLiveData<String> = MutableLiveData()
    val resultTitles: MutableLiveData<List<QiitaInfo>> = MutableLiveData()

    override fun onCleared() {
        super.onCleared()

        disposables.clear()
    }

    fun getQiitaArticle(tag: String) {
        qiitaService.getItemsByTag(tag)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { list ->
                    list?.let {
                        val titleList = it
                        if (titleList.isNotEmpty()){
                            result.value = "成功"
                        } else {
                            result.value = "失敗"
                        }
                    }?:run {
                        result.value = "失敗"
                    }
                }, { t->
                    result.value = "失敗"
                }
            ).also {
                disposables.add(it)
            }
    }
}