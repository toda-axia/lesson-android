package com.axiaworks.toda.feature.dialogfragment

import android.content.DialogInterface
import android.graphics.Color
import androidx.fragment.app.Fragment
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.axiaworks.toda.R
import kotlinx.android.synthetic.main.dialog_content.view.*
import kotlinx.android.synthetic.main.fragment_dialog_frament.*

/**
 * A placeholder fragment containing a simple view.
 */
class DialogFramentActivityFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = LayoutInflater.from(context).inflate(R.layout.dialog_content, container, false)
        v.dialog_text_view.text = "Fragment"
        v.dialog_text_view.setTextColor(Color.BLACK)
        return v
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dialog_fragment_button1.setOnClickListener {
            val newFragment = SimpleDialogFragment()
            newFragment.show(supportFragmentManager, "")
        }
    }
}
