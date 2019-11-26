package com.axiaworks.toda.feature.dialog_fragment

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.axiaworks.toda.R
import com.axiaworks.toda.feature.recyclerview.RecyclerViewActivity

class DialogFragmentActivity : AppCompatActivity(), LogCountListener {
    companion object {
        fun callingIntent(context: Context) = Intent(context, DialogFragmentActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dialog_fragment)
    }

    override fun countLog(log: String) {
        Log.d("TAG", log)
    }
}
