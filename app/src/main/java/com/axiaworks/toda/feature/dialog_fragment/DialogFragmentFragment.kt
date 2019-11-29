package com.axiaworks.toda.feature.dialog_fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager

import com.axiaworks.toda.R
import kotlinx.android.synthetic.main.fragment_dialog.*

class DialogFragmentFragment : Fragment() {
    private val dialogLogDataSet = arrayListOf<String>()
    private val adapter = DialogLogAdapter(dialogLogDataSet)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_dialog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()

        dialogfragment_button1.setOnClickListener {
            val dialogFragment1 = SimpleDialog()
            dialogFragment1.show(requireFragmentManager(), SimpleDialog.TAG)
        }

        dialogfragment_button2.setOnClickListener {
            val dialogFragment2 = LogDialog()
            dialogFragment2.show(requireFragmentManager(), LogDialog.TAG)
        }
    }

    fun setLogToAdapter(dialogLog: String) {
        dialogLogDataSet.add(dialogLog)
        scrollToLatest()
    }

    private fun initRecyclerView() {
        dialog_log_view.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(activity)
            adapter = this@DialogFragmentFragment.adapter
        }
    }

    private fun scrollToLatest() {
        dialog_log_view.scrollToPosition(dialogLogDataSet.size - 1)
    }
}
