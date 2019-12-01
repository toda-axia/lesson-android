package com.axiaworks.toda.feature.dialog_fragment2

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.axiaworks.toda.R

class DialogFragment2Activity : AppCompatActivity() {
    private var dialogFragment2Fragment: DialogFragment2Fragment? = null

    companion object {
        fun callingIntent(context: Context) = Intent(context, DialogFragment2Activity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dialog_fragment2)

        dialogFragment2Fragment = supportFragmentManager.findFragmentById(R.id.dialogfragment_container) as DialogFragment2Fragment
    }
}
