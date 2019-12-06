package com.axiaworks.toda.feature.qiitaclient

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.axiaworks.toda.R
import com.axiaworks.toda.feature.viewpager.SliderPage1Fragment
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_qiita_client.*

class QiitaClientActivity: AppCompatActivity() {

    companion object {
        fun callingIntent(context: Context) = Intent(context, QiitaClientActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_qiita_client)

        qiita_pager.adapter = QiitaPageAdapter(this)
        TabLayoutMediator(qiita_tabs, qiita_pager) { tab, position ->
            tab.text = "Tab ${position + 1}"
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