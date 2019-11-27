package com.axiaworks.toda.feature.dialog_fragment

import android.app.Dialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.axiaworks.toda.R
import kotlinx.android.synthetic.main.simple_dialog.view.*

class SimpleDialog : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        this.isCancelable = false

        val simpleDialogView = activity!!.layoutInflater.inflate(R.layout.simple_dialog, null)
        val okButton = simpleDialogView.findViewById(R.id.dialogfragment_dialog1_ok_button) as Button
        okButton.setOnClickListener {
            dismissAllowingStateLoss()
            Log.d("TAG", "メソッド呼べてる")
        }

        return AlertDialog.Builder(requireContext())
            .apply {
//                setTitle(R.string.dialog_fragment1)
//                setMessage(R.string.dialogfragment_dialog1_content)
//                setPositiveButton(android.R.string.yes) { _, _ ->
//                    dismissAllowingStateLoss()
//
                setView(LayoutInflater.from(getActivity()).inflate(R.layout.simple_dialog, null))
            }.create()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val simpleDialogView = activity!!.layoutInflater.inflate(R.layout.simple_dialog, null)
        val ok_button = simpleDialogView.findViewById(R.id.dialogfragment_dialog1_ok_button) as Button
        ok_button.setOnClickListener {
            dismissAllowingStateLoss()
            Log.d("TAG", "メソッド呼べてる")
        }
    }
}