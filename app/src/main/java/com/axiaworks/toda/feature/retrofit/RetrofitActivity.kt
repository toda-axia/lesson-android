package com.axiaworks.toda.feature.retrofit

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.axiaworks.toda.R

class RetrofitActivity : AppCompatActivity() {
    companion object {
        fun callingIntent(context: Context) = Intent(context, RetrofitActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retrofit)
    }
}
