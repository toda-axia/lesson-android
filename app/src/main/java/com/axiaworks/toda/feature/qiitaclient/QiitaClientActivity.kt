package com.axiaworks.toda.feature.qiitaclient

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.axiaworks.toda.R
import com.axiaworks.toda.feature.viewpager.SliderPage1Fragment
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
            Log.e("QiitaClientActivity", "$it")
            it?.let {count ->
                if (count == 0){
                    progress_container.visibility = View.GONE
                } else {
                    progress_container.visibility = View.VISIBLE
                }
            }
        })

        qiita_pager.adapter = QiitaPageAdapter(this)
        TabLayoutMediator(qiita_tabs, qiita_pager) { tab, position ->
            val tabArray = arrayListOf("Android", "Firebase", "Flutter")
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
            0 -> ArticleFragment()
            1 -> ArticleFragment()
            2 -> ArticleFragment()
            else -> SliderPage1Fragment()
        }
    }
}