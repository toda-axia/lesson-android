package com.axiaworks.toda.feature.dialog_fragment

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment

import com.axiaworks.toda.R
import kotlinx.android.synthetic.main.fragment_log_dialog.*
import com.axiaworks.toda.databinding.FragmentLogDialogBinding

class LogDialogFragment : DialogFragment() {
    private lateinit var binding: FragmentLogDialogBinding
    private var listener: LogCountListener? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as? LogCountListener
    }

    override fun onDetach() {
        listener = null
        super.onDetach()
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        binding = DataBindingUtil.inflate<FragmentLogDialogBinding>(
            LayoutInflater.from(context), R.layout.fragment_log_dialog, null, false
        ).apply {
            dialogfragmentDialog2NegativeButton.setOnClickListener {
                listener?.countLog("NO")
                dismissAllowingStateLoss()
            }
            dialogfragmentDialog2PositiveButton.setOnClickListener{
                listener?.countLog("YES")
                dismissAllowingStateLoss()
            }
        }

        return Dialog(requireContext()).apply {
            setContentView(binding.root)

            window!!.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        }
    }

    companion object {
        const val TAG = "LogDialog"
        fun getInstance() = LogDialogFragment()
    }
}

interface LogCountListener {
    fun countLog(log: String)
}
