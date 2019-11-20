package com.axiaworks.toda.feature.firebase

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.axiaworks.toda.R

class FirebaseAnalyticsActivity : AppCompatActivity() {
    companion object {
        fun callingIntent(context: Context) = Intent(context, FirebaseAnalyticsActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_firebase_analytics)
    }
}
