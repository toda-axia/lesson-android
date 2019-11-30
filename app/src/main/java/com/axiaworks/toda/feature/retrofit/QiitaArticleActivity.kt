package com.axiaworks.toda.feature.retrofit

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.axiaworks.toda.R
import kotlinx.android.synthetic.main.activity_qiita_article.*

class QiitaArticleActivity : AppCompatActivity() {

    companion object {
        private const val INTENT_EXTRA_QIITA_TITLE = "com.axiaworks.toda.INTENT_QIITA_TITLE"
        private const val INTENT_EXTRA_QIITA_CONTENT = "com.axiaworks.toda.INTENT_QIITA_CONTENT"

        fun callingIntent(context: Context, title: String, content: String): Intent {
            val intent = Intent(context, QiitaArticleActivity::class.java)
            intent.putExtra(INTENT_EXTRA_QIITA_TITLE, title)
            intent.putExtra(INTENT_EXTRA_QIITA_CONTENT, content)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_qiita_article)

        val title = intent.getStringExtra(INTENT_EXTRA_QIITA_TITLE)
        val content = intent.getStringExtra(INTENT_EXTRA_QIITA_CONTENT)
        qiita_title_text.text = title
        qiita_content_text.text = content
    }
}
