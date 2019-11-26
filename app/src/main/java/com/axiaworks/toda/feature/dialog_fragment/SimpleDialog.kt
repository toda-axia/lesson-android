package com.axiaworks.toda.feature.dialog_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment

import com.axiaworks.toda.R
import kotlinx.android.synthetic.main.simple_dialog.*


class SimpleDialog : DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
         return inflater.inflate(R.layout.simple_dialog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dialogfragment_dialog1_ok_button.setOnClickListener {
            dismissAllowingStateLoss()
        }
    }
}
