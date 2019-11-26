package com.axiaworks.toda.feature.dialog_fragment

import android.app.Dialog
import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment

import com.axiaworks.toda.R
import kotlinx.android.synthetic.main.fragment_simple_dialog.*
import kotlinx.android.synthetic.main.fragment_simple_dialog.view.*


class SimpleDialogFragment : DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
         return inflater.inflate(R.layout.fragment_simple_dialog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dialogfragment_dialog1_ok_button.setOnClickListener {
            dismissAllowingStateLoss()
        }

    }
}
