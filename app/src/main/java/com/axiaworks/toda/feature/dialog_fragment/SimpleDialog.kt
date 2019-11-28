package com.axiaworks.toda.feature.dialog_fragment

import android.app.Dialog
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.axiaworks.toda.R

class SimpleDialog : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        this.isCancelable = false

        val simpleDialogView = View.inflate(context, R.layout.simple_dialog, null)
        val okButton = simpleDialogView.findViewById(R.id.dialogfragment_dialog1_ok_button) as Button
        okButton.setOnClickListener {
            dismissAllowingStateLoss()
        }

        return AlertDialog.Builder(requireContext())
            .apply {
                setView(simpleDialogView)
            }.create()
    }
}