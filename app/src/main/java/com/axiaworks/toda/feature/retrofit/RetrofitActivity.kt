package com.axiaworks.toda.feature.retrofit

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.axiaworks.toda.R
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.plugins.RxJavaPlugins.onError
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_retrofit.*

class RetrofitActivity : AppCompatActivity() {
    private lateinit var observable: Observable<List<QiitaInfo>>
    private lateinit var disposable: Disposable

    companion object {
        fun callingIntent(context: Context) = Intent(context, RetrofitActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retrofit)

        getQiitaInfo()

        swipe_refresh_layout.setOnRefreshListener {
            getQiitaInfo()
            swipe_refresh_layout.isRefreshing = false
        }
    }

    override fun onPause() {
        super.onPause()

        disposable.dispose()
    }

    private fun doSomethingToList(list: List<QiitaInfo>) {
        qiita_title_view.adapter = QiitaInfoAdapter(this, list)
        qiita_title_view.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }

    private fun getQiitaInfo() {
        val service = QiitaClient().getClient().create(QiitaService::class.java)
        observable = service.getItemsByTag("Android")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .retry(3)

        disposable = observable
            .subscribe(
                { list -> doSomethingToList(list) }
                , { t -> onError(t) }
            )
    }
}
