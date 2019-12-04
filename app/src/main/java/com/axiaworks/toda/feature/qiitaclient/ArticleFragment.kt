package com.axiaworks.toda.feature.qiitaclient

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.axiaworks.toda.R
import org.koin.android.viewmodel.ext.android.sharedViewModel

class ArticleFragment: Fragment() {
    private val qiitaClientViewModel: QiitaClientViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_article, container, false)
    }
}