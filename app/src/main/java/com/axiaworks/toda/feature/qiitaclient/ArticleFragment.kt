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

const val ANDROID_TAG = "Android"
const val FIREBASE_TAG = "Firebase"
const val FLUTTER_TAG = "Flutter"

class ArticleFragment: Fragment() {
    private val qiitaClientViewModel: QiitaClientViewModel by sharedViewModel()
    private var tagText = ""

    companion object{
        const val QIITA_TAG = "QiitaItemTag"
        fun newInstance(tag: String): ArticleFragment {
            val bundle = Bundle().apply {
                putSerializable(QIITA_TAG, tag)
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
        when (tagText) {
            ANDROID_TAG -> {
                qiitaClientViewModel.androidArticleList.observe(this, Observer { qiitaInfo ->
                    qiitaInfo?.let { qiitaInfoList ->
                        qiita_client_title_view.adapter = QiitaClientAdapter(requireContext(), qiitaInfoList, qiitaClientViewModel)
                    }
                    qiita_client_title_view.adapter?.notifyDataSetChanged()
                })
            }
            FIREBASE_TAG -> {
                qiitaClientViewModel.firebaseArticleList.observe(this, Observer { qiitaInfo ->
                    qiitaInfo?.let { qiitaInfoList ->
                        qiita_client_title_view.adapter = QiitaClientAdapter(requireContext(), qiitaInfoList, qiitaClientViewModel)
                    }
                    qiita_client_title_view.adapter?.notifyDataSetChanged()
                })
            }
            FLUTTER_TAG -> {
                qiitaClientViewModel.flutterArticleList.observe(this, Observer { qiitaInfo ->
                    qiitaInfo?.let { qiitaInfoList ->
                        qiita_client_title_view.adapter = QiitaClientAdapter(requireContext(), qiitaInfoList, qiitaClientViewModel)
                    }
                    qiita_client_title_view.adapter?.notifyDataSetChanged()
                })
            }
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
            ANDROID_TAG -> {
                qiitaClientViewModel.getAndroidArticle()
            }
            FIREBASE_TAG -> {
                qiitaClientViewModel.getFirebaseArticle()
            }
            FLUTTER_TAG -> {
                qiitaClientViewModel.getFlutterArticle()
            }
        }
    }

    private fun getQiitaTag() = arguments!!.getString(QIITA_TAG)!!
}