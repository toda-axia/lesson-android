package com.axiaworks.toda.feature.dialogfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment

import com.axiaworks.toda.R
import kotlinx.android.synthetic.main.dialog_content.view.*
import kotlinx.android.synthetic.main.fragment_dialog_frament.*


class SimpleDialogFragment : DialogFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = LayoutInflater.from(context).inflate(R.layout.dialog_content, container, false)
        v.dialog_text_view.text = "Dialog"
        return v
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}