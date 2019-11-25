package com.axiaworks.toda.feature.dialogfragment

import androidx.fragment.app.Fragment
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.axiaworks.toda.R
import kotlinx.android.synthetic.main.fragment_dialog_frament.*

/**
 * A placeholder fragment containing a simple view.
 */
class DialogFramentActivityFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_dialog_frament, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dialog_fragment_button1.setOnClickListener {
            Log.d("DialogFragment", "ダイアログ1")
        }

        dialog_fragment_button2.setOnClickListener {
            Log.d("DialogFragment", "ダイアログ2")
        }
    }
}
