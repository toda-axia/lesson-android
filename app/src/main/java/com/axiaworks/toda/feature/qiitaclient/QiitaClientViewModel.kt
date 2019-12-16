package com.axiaworks.toda.feature.qiitaclient

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import org.koin.core.KoinComponent
import org.koin.core.inject

class QiitaClientViewModel: ViewModel(), KoinComponent {
    private val qiitaService: QiitaClientService by inject()
    private val disposables = CompositeDisposable()
    val androidArticleList: MutableLiveData<List<QiitaInfo>> = MutableLiveData(listOf())
    val firebaseArticleList: MutableLiveData<List<QiitaInfo>> = MutableLiveData(listOf())
    val flutterArticleList: MutableLiveData<List<QiitaInfo>> = MutableLiveData(listOf())
    val qiitaApiProgressCount: MutableLiveData<Int> = MutableLiveData(0)
    val qiitaId: MutableLiveData<String> = MutableLiveData("")

    companion object {
        private const val TAG = "QiitaViewModel"
    }

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
                        if (tag == ANDROID_TAG) {
                            androidArticleList.value = titleList
                        }
                        if (tag == FIREBASE_TAG) {
                            firebaseArticleList.value = titleList
                        }
                        if (tag == FLUTTER_TAG) {
                            flutterArticleList.value = titleList
                        }
                    }
                }, { t ->
                    Log.w(TAG, t)
                    qiitaApiProgressCount.value = qiitaApiProgressCount.value!! - 1
                }
            ).also {
                disposables.add(it)
            }
    }

    fun getAndroidArticle() {
        getQiitaArticle(ANDROID_TAG)
    }

    fun getFirebaseArticle() {
        getQiitaArticle(FIREBASE_TAG)
    }

    fun getFlutterArticle() {
        getQiitaArticle(FLUTTER_TAG)
    }

    fun tapItems(id: String) {
        qiitaId.value = id
    }
}