package com.axiaworks.toda.feature.dialog_fragment

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

import com.axiaworks.toda.R


class SimpleDialog : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        this.isCancelable = false
        return AlertDialog.Builder(requireContext())
            .apply {
                setTitle(R.string.dialog_fragment1)
                setMessage(R.string.dialogfragment_dialog1_content)
                setPositiveButton(android.R.string.yes) { _, _ ->
                    dismissAllowingStateLoss()
                }
            }.create()
    }
}