package com.axiaworks.toda.feature.dialog_fragment

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment

import com.axiaworks.toda.R
import kotlinx.android.synthetic.main.fragment_simple_dialog.view.*


class SimpleDialogFragment : DialogFragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        val v = LayoutInflater.from(context).inflate(R.layout.fragment_simple_dialog, container, false)
//        v.dialog_text_view.text = "Dialog"
//        return v
        // Inflate the layout for this fragment
         return inflater.inflate(R.layout.fragment_simple_dialog, container, false)
    }
}
