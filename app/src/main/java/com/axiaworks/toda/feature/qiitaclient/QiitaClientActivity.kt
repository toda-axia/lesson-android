package com.axiaworks.toda.feature.qiitaclient

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.axiaworks.toda.R
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_qiita_client.*
import org.koin.android.viewmodel.ext.android.viewModel

class QiitaClientActivity: AppCompatActivity() {
    private val qiitaClientViewModel: QiitaClientViewModel by viewModel()

    companion object {
        fun callingIntent(context: Context) = Intent(context, QiitaClientActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_qiita_client)

        qiitaClientViewModel.qiitaApiProgressCount.observe(this, Observer {
            it?.let {count ->
                if (count == 0){
                    progress_container.visibility = View.GONE
                } else {
                    progress_container.visibility = View.VISIBLE
                }
            }
        })

        qiitaClientViewModel.qiitaId.observe(this, Observer {
            val qiitaContentDialog = QiitaContentDialogFragment()
            if (qiitaClientViewModel.qiitaId.value != "") {
                qiitaContentDialog.show(supportFragmentManager, "QiitaContentDialogFragment")
            }
        })

        qiita_pager.adapter = QiitaPageAdapter(this)
        TabLayoutMediator(qiita_tabs, qiita_pager) { tab, position ->
            val tabArray = arrayListOf(ANDROID_TAG, FIREBASE_TAG, FLUTTER_TAG)
            tab.text = tabArray[position]
        }.attach()
    }
}

class QiitaPageAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {
    companion object {
        const val NUM_PAGES = 3
    }

    override fun getItemCount(): Int = NUM_PAGES

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> ArticleFragment.newInstance(ANDROID_TAG)
            1 -> ArticleFragment.newInstance(FIREBASE_TAG)
            2 -> ArticleFragment.newInstance(FLUTTER_TAG)
            else -> ArticleFragment.newInstance(ANDROID_TAG)
        }
    }
}