package com.axiaworks.toda.feature.firebase

import android.content.Context
import android.content.Intent
import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.axiaworks.toda.R
import kotlinx.android.synthetic.main.activity_firebase_analytics.*
import java.text.SimpleDateFormat
import java.util.*

class FirebaseAnalyticsActivity : AppCompatActivity() {

    private val logDataSet = arrayListOf<String>()
    val log_adapter = LogRecyclerViewAdapter(logDataSet)

    companion object {
        val TAG: String = "Firebase"
        fun callingIntent(context: Context) = Intent(context, FirebaseAnalyticsActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_firebase_analytics)

        log_button1.setOnClickListener {
            addLogData(1)
            initRecyclerView()
        }

        log_button2.setOnClickListener {
            addLogData(2)
            initRecyclerView()
        }

        log_button3.setOnClickListener {
            addLogData(3)
            initRecyclerView()
            log_adapter.notifyDataSetChanged()
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
    }

    private fun initRecyclerView() {
        log_view.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@FirebaseAnalyticsActivity)
            adapter = LogRecyclerViewAdapter(logDataSet)
        }
    }
}
