package com.axiaworks.toda.feature.firebase

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.axiaworks.toda.R
import com.axiaworks.toda.utils.AnalyticsUtils
import kotlinx.android.synthetic.main.activity_firebase_analytics.*
import java.text.SimpleDateFormat
import java.util.*

class FirebaseAnalyticsActivity : AppCompatActivity() {

    private val logDataSet = arrayListOf<String>()
    private val adapter = LogRecyclerViewAdapter(logDataSet)

    companion object {
        @Suppress("unused")
        private const val TAG: String = "Firebase"
        fun callingIntent(context: Context) = Intent(context, FirebaseAnalyticsActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_firebase_analytics)
        initRecyclerView()

        log_button1.setOnClickListener {
            logButtonTapped(1)
            addLogData(1)
            scrollToLatest()
        }

        log_button2.setOnClickListener {
            logButtonTapped(2)
            addLogData(2)
            scrollToLatest()
        }

        log_button3.setOnClickListener {
            logButtonTapped(3)
            addLogData(3)
            scrollToLatest()
        }
    }

    private fun getTimeStamp(): String {
        val date = Date()
        val format = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
        return format.format(date)
    }

    private fun addLogData(button_number: Int) {
        val logDateTime: String = getTimeStamp()
        val logData = "$logDateTime: click ボタン$button_number"
        logDataSet.add(logData)
        if (logDataSet.size > 100) {
            logDataSet.removeAt(0)
        }
        adapter.notifyDataSetChanged()
    }

    private fun initRecyclerView() {
        log_view.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@FirebaseAnalyticsActivity)
            adapter = this@FirebaseAnalyticsActivity.adapter
        }
    }

    private fun logButtonTapped(button_number: Int) {
        AnalyticsUtils.sendClickEventLog(baseContext, "firebase_button$button_number")
    }

    private fun scrollToLatest() {
        log_view.scrollToPosition(logDataSet.size - 1)
    }
}
