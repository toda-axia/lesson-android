package com.axiaworks.toda.feature.dialogfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.axiaworks.toda.R
import com.axiaworks.toda.SampleModel
import com.axiaworks.toda.databinding.FragmentDialogFramentBinding
import kotlinx.android.synthetic.main.fragment_dialog_frament.*

/**
 * A placeholder fragment containing a simple view.
 */
class DialogFramentActivityFragment : Fragment() {

    private lateinit var binding: FragmentDialogFramentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate<FragmentDialogFramentBinding>(
            LayoutInflater.from(context),
            R.layout.fragment_dialog_frament,
            container,
            false
        ).apply {
            model = SampleModel("ボタン１", "ボタン２")
        }


        val v =
            LayoutInflater.from(context).inflate(R.layout.fragment_dialog_frament, container, false)
//        v.dialog_text_view.text = "Fragment"
//        v.dialog_text_view.setTextColor(Color.BLACK)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.dialogFragmentButton1?.setOnClickListener {

        }

        dialog_fragment_button1.setOnClickListener {
            val newFragment = SimpleDialogFragment()

            newFragment.show(requireFragmentManager(), "")
        }
    }
}
