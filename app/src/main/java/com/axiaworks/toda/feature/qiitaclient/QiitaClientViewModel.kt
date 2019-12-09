package com.axiaworks.toda.feature.qiitaclient

import android.util.Log
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
    val androidArticleList: MutableLiveData<List<QiitaInfo>> = MutableLiveData(listOf())
    val firebaseArticleList: MutableLiveData<List<QiitaInfo>> = MutableLiveData(listOf())
    val flutterArticleList: MutableLiveData<List<QiitaInfo>> = MutableLiveData(listOf())
    val qiitaApiProgressCount: MutableLiveData<Int> = MutableLiveData(0)
    val qiitaTouchItem: MutableLiveData<Int> = MutableLiveData(-1)
    val qiitaId: MutableLiveData<String> = MutableLiveData("")

    override fun onCleared() {
        super.onCleared()

        disposables.clear()
    }

    private fun getQiitaArticle(tag: String) {
        qiitaApiProgressCount.value = qiitaApiProgressCount.value!! + 1
        qiitaService.getItemsByTag(tag)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { list ->
                    qiitaApiProgressCount.value = qiitaApiProgressCount.value!! - 1
                    list?.let {titleList ->
                        if (tag == "Android") {
                            androidArticleList.value = titleList
                        }
                        if (tag == "Firebase") {
                            firebaseArticleList.value = titleList
                        }
                        if (tag == "Flutter") {
                            flutterArticleList.value = titleList
                        }
                        titleList.forEach {
                            Log.d("ViewModel", it.title)
                        }
                    }
                }, { t ->
                    Log.w("QiitaViewModel", t)
                    qiitaApiProgressCount.value = qiitaApiProgressCount.value!! - 1
                }
            ).also {
                disposables.add(it)
            }
    }

    fun getAndroidArticle() {
        getQiitaArticle("Android")
    }

    fun getFirebaseArticle() {
        getQiitaArticle("Firebase")
    }

    fun getFlutterArticle() {
        getQiitaArticle("Flutter")
    }

    fun tapItems(id: String) {
        qiitaId.value = id
    }


}