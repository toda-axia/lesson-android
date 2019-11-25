package com.axiaworks.toda.feature.dialogfragment

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.axiaworks.toda.R
import com.axiaworks.toda.feature.recyclerview.RecyclerViewActivity

import kotlinx.android.synthetic.main.activity_dialog_frament.*

class DialogFramentActivity : AppCompatActivity() {

    companion object {
        fun callingIntent(context: Context) = Intent(context, DialogFramentActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dialog_frament)
    }

}
