package com.axiaworks.toda.feature.todo_mvvm

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.axiaworks.toda.R
import kotlinx.android.synthetic.main.activity_todo_new.*

class TodoNewActivity : AppCompatActivity() {
    companion object {
        fun callingIntent(context: Context) = Intent(context, TodoNewActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo_new)

        input_task_fab.setOnClickListener {

        }
    }
}
