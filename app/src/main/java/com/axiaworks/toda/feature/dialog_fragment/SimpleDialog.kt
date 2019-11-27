package com.axiaworks.toda.feature.dialog_fragment

import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment

import com.axiaworks.toda.R
import com.axiaworks.toda.databinding.LogDialogBinding
import kotlinx.android.synthetic.main.simple_dialog.*


class SimpleDialog : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        this.isCancelable = false
        return AlertDialog.Builder(requireContext())
            .apply {
                setTitle(R.string.dialog_fragment1)
                setMessage(R.string.dialogfragment_dialog1_content)
                setPositiveButton(android.R.string.yes){ _, _ ->
                    dismissAllowingStateLoss()
                }
            }.create()





//        val builder = AlertDialog.Builder(context!!)
//        builder.setTitle(R.string.dialog_fragment1)
//        builder.setMessage(R.string.dialogfragment_dialog1_content)
//        builder.setPositiveButton(R.string.yes, DialogButtonClickListener())
////        builder.setCancelable(false)
//        this.isCancelable = false
//        val dialog = builder.create()
//        return dialog
    }

//    private inner class DialogButtonClickListener : DialogInterface.OnClickListener {
//        override fun onClick(dialog: DialogInterface?, which: Int) {
//            dismissAllowingStateLoss()
//        }
//    }

//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        return inflater.inflate(R.layout.simple_dialog, container, false)
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//        dialogfragment_dialog1_ok_button.setOnClickListener {
//            dismissAllowingStateLoss()
//        }
//    }

}