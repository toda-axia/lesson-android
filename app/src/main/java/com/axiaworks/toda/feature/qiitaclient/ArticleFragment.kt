package com.axiaworks.toda.feature.qiitaclient

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.axiaworks.toda.R
import kotlinx.android.synthetic.main.activity_qiita_client.*
import kotlinx.android.synthetic.main.activity_retrofit.*
import kotlinx.android.synthetic.main.fragment_article.*
import org.koin.android.viewmodel.ext.android.sharedViewModel
import java.util.*


// ViewModelのAPIをコールする
// コールした時のログを出力
//　コールされた値をフラグメント側で受け取る
// ログを出力
//　Adapterにセットする
//　



class ArticleFragment: Fragment() {
    private val qiitaClientViewModel: QiitaClientViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_article, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        swipe_to_refresh_qiita_client.setOnRefreshListener{
            qiitaClientViewModel.getAndroidArticle()
            qiita_api_progress
        }

    }

    override fun onResume() {
        super.onResume()

        qiitaClientViewModel.getAndroidArticle()
        qiitaClientViewModel.androidArticleList.observe(this, Observer{
            it?.let{qiitaInfoList ->
                qiita_client_title_view.adapter =
                    QiitaClientAdapter(requireContext(), qiitaInfoList)
                qiitaInfoList.forEach {
                    Log.d("ArticleFragment", it.title)
                }
            }
            qiita_client_title_view.adapter?.notifyDataSetChanged()
        })
    }


}