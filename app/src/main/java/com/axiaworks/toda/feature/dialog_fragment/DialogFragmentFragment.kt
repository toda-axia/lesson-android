package com.axiaworks.toda.feature.dialog_fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.axiaworks.toda.R
import kotlinx.android.synthetic.main.fragment_dialog.*

class DialogFragmentFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dialog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dialogfragment_button1.setOnClickListener {
            val dialogFragment1 = SimpleDialog()
            dialogFragment1.show(requireFragmentManager(), "SimpleDialogFragment")
        }

        dialogfragment_button2.setOnClickListener {
            val dialogFragment2 = LogDialog()
            dialogFragment2.show(requireFragmentManager(), "LogDialogFragment")
        }
    }
}
