package com.axiaworks.toda.feature.retrofit

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.axiaworks.toda.R
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_retrofit.*
import okhttp3.ResponseBody

class RetrofitActivity : AppCompatActivity() {
    private lateinit var observable: Observable<ResponseBody>
    private lateinit var disposable: Disposable

    companion object {
        fun callingIntent(context: Context) = Intent(context, RetrofitActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retrofit)

        setTagforQiita("Android")

        get_article_button.setOnClickListener {
            getQiitaArticle()
        }
    }

    private fun setTagforQiita(tag: String) {
        val service = QiitaClient().getClient().create(QiitaService::class.java)
        observable = service.getItemsByTag(tag)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .retry(3)
    }

    private fun getQiitaArticle() {
        disposable = observable.subscribe {
                responseBody: ResponseBody? ->
                responseBody?.let {
                    val body = it.string()
                    if (body.isNotEmpty()) {
                        result_article_text.text = body
                    }
                }
            }
    }
}
