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
            val fragment = ArticleFragment()
            var bundle = Bundle()
            bundle.putString("QIITA_TAG", tag)
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (arguments != null) {
            tagText = arguments?.getString("QIITA_TAG")!!
        }
        return inflater.inflate(R.layout.fragment_article, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        qiitaClientViewModel.androidArticleList.observe(this, Observer {
            it?.let { qiitaInfoList ->
                qiita_client_title_view.adapter = QiitaClientAdapter(requireContext(), qiitaInfoList, qiitaClientViewModel)
            }
            qiita_client_title_view.adapter?.notifyDataSetChanged()
        })
        qiitaClientViewModel.firebaseArticleList.observe(this, Observer {
            it?.let { qiitaInfoList ->
                qiita_client_title_view.adapter = QiitaClientAdapter(requireContext(), qiitaInfoList, qiitaClientViewModel)
            }
            qiita_client_title_view.adapter?.notifyDataSetChanged()
        })
        qiitaClientViewModel.flutterArticleList.observe(this, Observer {
            it?.let { qiitaInfoList ->
                qiita_client_title_view.adapter = QiitaClientAdapter(requireContext(), qiitaInfoList, qiitaClientViewModel)
            }
            qiita_client_title_view.adapter?.notifyDataSetChanged()
        })

        swipe_to_refresh_qiita_client.setOnRefreshListener{
            swipe_to_refresh_qiita_client.isRefreshing = false
            displayContentByTag(tagText)
        }
    }

    override fun onResume() {
        super.onResume()
        displayContentByTag(tagText)
    }

    fun displayContentByTag(tag: String) {
        when (tagText) {
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
}