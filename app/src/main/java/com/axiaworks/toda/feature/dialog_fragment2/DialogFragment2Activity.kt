package com.axiaworks.toda.feature.dialog_fragment2

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import com.axiaworks.toda.R
import kotlinx.android.synthetic.main.fragment_dialog2.*

class DialogFragment2Activity : AppCompatActivity(), DatePickerDialog.OnDateSetListener {
    private var dialogFragment2Fragment: DialogFragment2Fragment? = null

    companion object {
        fun callingIntent(context: Context) = Intent(context, DialogFragment2Activity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dialog_fragment2)

        dialogFragment2Fragment = supportFragmentManager.findFragmentById(R.id.dialogfragment_container) as DialogFragment2Fragment
    }

    override fun onDateSelected(dateString: String) {
        val inputDateText = findViewById<EditText>(R.id.inputDateText)
        inputDateText.setText(dateString)
        //inputDateText.text = dateString
    }
}
