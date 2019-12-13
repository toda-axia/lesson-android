package com.axiaworks.toda.feature.qiitaclient

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.axiaworks.toda.R
import kotlinx.android.synthetic.main.fragment_article.*
import org.koin.android.viewmodel.ext.android.sharedViewModel

class ArticleFragment: Fragment() {
    private val qiitaClientViewModel: QiitaClientViewModel by sharedViewModel()
    private var tagText = ""

    companion object{
        fun newInstance(tag: String): ArticleFragment {
            val bundle = Bundle().apply {
                putSerializable("QIITA_TAG", tag)
            }
            return ArticleFragment().apply {
                arguments = bundle
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        arguments?.let {
            tagText = getQiitaTag()
        }
        return inflater.inflate(R.layout.fragment_article, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val arrayArticleList = arrayListOf(
            qiitaClientViewModel.androidArticleList,
            qiitaClientViewModel.firebaseArticleList,
            qiitaClientViewModel.flutterArticleList
        )

        arrayArticleList.forEach {
            it.observe(this, Observer { qiitaInfo ->
                qiitaInfo?.let { qiitaInfoList ->
                    qiita_client_title_view.adapter = QiitaClientAdapter(requireContext(), qiitaInfoList, qiitaClientViewModel)
                }
                qiita_client_title_view.adapter?.notifyDataSetChanged()
            })
        }

        swipe_to_refresh_qiita_client.setOnRefreshListener{
            swipe_to_refresh_qiita_client.isRefreshing = false
            switchArticleByTag(tagText)
        }
    }

    override fun onResume() {
        super.onResume()
        switchArticleByTag(tagText)
    }

    private fun switchArticleByTag(tag: String) {
        when (tag) {
            "Android" -> {
                qiitaClientViewModel.getAndroidArticle()
            }
            "Firebase" -> {
                qiitaClientViewModel.getFirebaseArticle()
            }
            "Flutter" -> {
                qiitaClientViewModel.getFlutterArticle()
            }
        }
    }

    private fun getQiitaTag() = arguments!!.getString("QIITA_TAG")!!
}