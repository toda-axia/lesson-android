package com.axiaworks.toda.feature.dialog_fragment

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment

import com.axiaworks.toda.R
import com.axiaworks.toda.databinding.LogDialogBinding

class LogDialog : DialogFragment() {
    private lateinit var binding: LogDialogBinding
    private var listener: LogCountListener? = null

    companion object {
        const val TAG = "LogDialog"
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as? LogCountListener
    }

    override fun onDetach() {
        listener = null
        super.onDetach()
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        this.isCancelable = false
        binding = DataBindingUtil.inflate<LogDialogBinding>(
            LayoutInflater.from(context), R.layout.log_dialog, null, false
        ).apply {
            dialogfragmentDialog2NegativeButton.setOnClickListener {
                listener?.logSelectedButton("NO")
                dismissAllowingStateLoss()
            }
            dialogfragmentDialog2PositiveButton.setOnClickListener{
                listener?.logSelectedButton("YES")
                dismissAllowingStateLoss()
            }
        }
        return Dialog(requireContext()).apply {
            setContentView(binding.root)
            window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        }
    }
}

interface LogCountListener {
    fun logSelectedButton(log: String)
}
