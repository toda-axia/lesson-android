package com.axiaworks.toda.feature.todo

import android.app.DatePickerDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.widget.DatePicker
import androidx.fragment.app.DialogFragment
import java.text.SimpleDateFormat
import java.util.*

class DatePickerDialogFragment: DialogFragment(), DatePickerDialog.OnDateSetListener {

    private var listener: OnDateSetListener? = null
    companion object {
        const val TAG = "DatePickerDialog"
    }

    interface OnDateSetListener {
        fun onDateSelected(dateString: String)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        return DatePickerDialog(requireContext(), this, year, month, day)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as? OnDateSetListener
    }

    override fun onDetach() {
        listener = null
        super.onDetach()
    }

    override fun onDateSet(datePicker: DatePicker?, year: Int, month: Int, day: Int) {
        val dateString = getDateString(year, month, day)
        listener?.onDateSelected(dateString)
    }

    private fun getDateString(year: Int, month: Int, day: Int): String {
        val calendar = Calendar.getInstance()
        calendar.set(year, month, day)
        val dateFormat = SimpleDateFormat("yyyy/MM/dd", Locale.JAPAN)
        return dateFormat.format(calendar.time)
    }
}