package com.axiaworks.toda.feature.qiitaclient

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.axiaworks.toda.R
import com.axiaworks.toda.feature.dialog_fragment.DialogFragmentFragment
import org.koin.android.viewmodel.ext.android.viewModel

class QiitaClientActivity: AppCompatActivity() {
    private val qiitaClientViewModel: QiitaClientViewModel by viewModel()

    companion object {
        fun callingIntent(context: Context) = Intent(context, QiitaClientActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_qiita_client)
    }


    override fun onResume() {
        super.onResume()

        qiitaClientViewModel.getQiitaArticle("Android")
        qiitaClientViewModel.result.observe(this, Observer{
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        })
    }
}