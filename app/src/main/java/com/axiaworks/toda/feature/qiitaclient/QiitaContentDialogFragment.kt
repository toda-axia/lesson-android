package com.axiaworks.toda.feature.qiitaclient

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.View
import androidx.fragment.app.DialogFragment
import com.axiaworks.toda.R

class QiitaContentDialogFragment: DialogFragment() {
    companion object {
        const val TAG = "QiitaContentDialogFragment"
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        this.isCancelable = false

        val qiitaContentDialog = View.inflate(context, R.layout.fragment_qiita_content_dialog, null)

        return AlertDialog.Builder(requireContext())
            .apply {
                setView(qiitaContentDialog)
            }.create()
    }
}