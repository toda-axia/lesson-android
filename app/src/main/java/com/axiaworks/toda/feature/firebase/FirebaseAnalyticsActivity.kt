package com.axiaworks.toda.feature.firebase

import android.content.Context
import android.content.Intent
import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.axiaworks.toda.R
import com.google.firebase.analytics.FirebaseAnalytics
import kotlinx.android.synthetic.main.activity_firebase_analytics.*
import java.text.SimpleDateFormat
import java.util.*

class FirebaseAnalyticsActivity : AppCompatActivity() {

    val logDataSet = arrayListOf<String>()
    val adapter = LogRecyclerViewAdapter(logDataSet)

    private lateinit var firebaseAnalytics: FirebaseAnalytics

    companion object {
        val TAG: String = "Firebase"
        fun callingIntent(context: Context) = Intent(context, FirebaseAnalyticsActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_firebase_analytics)

        firebaseAnalytics = FirebaseAnalytics.getInstance(this)

        log_button1.setOnClickListener {
            logButtonAnalytics(1)
            addLogData(1)
            initRecyclerView()
        }

        log_button2.setOnClickListener {
            logButtonAnalytics(2)
            addLogData(2)
            initRecyclerView()
        }

        log_button3.setOnClickListener {
            logButtonAnalytics(3)
            addLogData(3)
            initRecyclerView()
        }
    }

    private fun getTimeStamp(): String {
        val date = Date()
        val format = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
        return format.format(date)
    }

    fun addLogData(button_number: Int) {
        val logDateTime: String = getTimeStamp()
        val logData: String = "$logDateTime: click ボタン$button_number"
        Log.d(TAG, "$logData")
        logDataSet.add(logData)
        Log.d(TAG, "$logDataSet")
        if (logDataSet.size > 100) {
            logDataSet.removeAt(0)
        }
        adapter.setList(logDataSet)
    }

    private fun initRecyclerView() {
        log_view.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@FirebaseAnalyticsActivity)
            adapter = LogRecyclerViewAdapter(logDataSet)

            var scrollPosition = logDataSet.size - 1
            log_view.scrollToPosition(scrollPosition)
        }
    }

    private fun logButtonAnalytics(button_number: Int) {
        val bundle = Bundle()
        bundle.putString(FirebaseAnalytics.Param.CONTENT_TYPE, "contentType")
        bundle.putString(FirebaseAnalytics.Param.ITEM_ID, "firebase_button$button_number")
        firebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle)
    }
}
