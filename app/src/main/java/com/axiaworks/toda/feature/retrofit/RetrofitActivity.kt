package com.axiaworks.toda.feature.retrofit

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.axiaworks.toda.R
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_retrofit.*
import okhttp3.ResponseBody

class RetrofitActivity : AppCompatActivity() {
    private lateinit var disposable: Disposable

    companion object {
        private const val TAG: String = "Retrofit"
        fun callingIntent(context: Context) = Intent(context, RetrofitActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retrofit)

        val service = QiitaClient().getClient().create(QiitaService::class.java)

        get_article_button.setOnClickListener {
            getQiitaArticle(service)
        }
    }

    override fun onPause() {
        super.onPause()

        disposable.dispose()
    }

    private fun getQiitaArticle(service: QiitaService) {
        disposable = service.getItemsByTag("Android")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                    responseBody: ResponseBody? ->
                responseBody?.let {
                    val body = it.string()
                    if (body.isNotEmpty()) {
                        result_article_text.text = body
                    }
                }
            },{ t ->
                onError(t)
            })
    }

    private fun onError(e: Throwable?) {
        Log.e(TAG, "onError", e)
    }
}
