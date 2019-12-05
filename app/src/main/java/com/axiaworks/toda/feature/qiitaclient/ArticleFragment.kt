package com.axiaworks.toda.feature.qiitaclient

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.axiaworks.toda.R
import kotlinx.android.synthetic.main.activity_retrofit.*
import kotlinx.android.synthetic.main.fragment_article.*
import org.koin.android.viewmodel.ext.android.sharedViewModel
import java.util.*

class ArticleFragment: Fragment() {
    private val qiitaClientViewModel: QiitaClientViewModel by sharedViewModel()
    private lateinit var viewModel: QiitaClientViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_article, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        swipe_to_refresh_qiita_client.setOnRefreshListener{
        }

    }

    fun doSomethingToList(list: List<QiitaInfo>) {
        qiita_client_title_view.adapter = QiitaClientAdapter(requireContext(), list)
        qiita_client_title_view.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
    }
}