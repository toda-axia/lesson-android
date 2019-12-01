package com.axiaworks.toda.feature.dialog_fragment2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.axiaworks.toda.R
import kotlinx.android.synthetic.main.fragment_dialog2.*

class DialogFragment2Fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dialog2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        datepicker_button.setOnClickListener {
            DatePickerDialog().show(requireFragmentManager(), DatePickerDialog.TAG)
        }
    }
}
