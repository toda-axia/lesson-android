package com.axiaworks.toda.feature.retrofit

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.axiaworks.toda.R
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.plugins.RxJavaPlugins
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_qiita_article.*

class QiitaArticleActivity : AppCompatActivity() {
    private lateinit var observable: Observable<List<QiitaInfo>>
    private lateinit var disposable: Disposable

    companion object {
        private const val INTENT_EXTRA_QIITA_TITLE = "com.axiaworks.toda.INTENT_QIITA_TITLE"
        private const val INTENT_EXTRA_QIITA_POSITION = "com.axiaworks.toda.INTENT_QIITA_POSITION"

        fun callingIntent(context: Context, title: String, position: Int): Intent {
            val intent = Intent(context, QiitaArticleActivity::class.java)
            intent.putExtra(INTENT_EXTRA_QIITA_TITLE, title)
            intent.putExtra(INTENT_EXTRA_QIITA_POSITION, position)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_qiita_article)

        val title = intent.getStringExtra(INTENT_EXTRA_QIITA_TITLE)
        val position = intent.getIntExtra(INTENT_EXTRA_QIITA_POSITION, 0)
        qiita_title_text.text = title
        getQiitaContent(position)
    }

    private fun getQiitaContent(item_num: Int) {
        val service = QiitaClient().getClient().create(QiitaService::class.java)
        observable = service.getItemsByTag("Android")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .retry(3)
        disposable = observable.subscribe(
            { list ->
                list[item_num].body.let {
                    qiita_content_text.text = it
                }
            }, { t ->
                RxJavaPlugins.onError(t)
            }
        )
    }
}
