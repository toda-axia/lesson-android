package com.axiaworks.toda.feature.todo

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.TextView
import com.axiaworks.toda.R
import kotlinx.android.synthetic.main.activity_todo_new.*

class TodoNewActivity : AppCompatActivity() {
    companion object {
        const val INTENT_EXTRA_TODO_TASK_NAME = "com.axiaworks.toda.INTENT_TODO_TASK_NAME"
        const val INTENT_EXTRA_TODO_TASK_DATE = "com.axiaworks.toda.INTENT_TODO_TASK_DATE"
        const val EXTRA_REPLY_NAME = "com.axiaworks.toda.feature.todo.REPLY"
        const val EXTRA_REPLY_DATE = "com.axiaworks.toda.feature.todo.REPLY_DATE"
        fun callingIntent(context: Context, name: String?, deadline: String?): Intent {
            val intent = Intent(context, TodoNewActivity::class.java)
            intent.putExtra(INTENT_EXTRA_TODO_TASK_NAME, name)
            intent.putExtra(INTENT_EXTRA_TODO_TASK_DATE, deadline)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo_new)

        val taskName = intent.getStringExtra(INTENT_EXTRA_TODO_TASK_NAME)
        edit_task.setText(taskName, TextView.BufferType.NORMAL)
        val taskDeadline = intent.getStringExtra(INTENT_EXTRA_TODO_TASK_DATE)
        edit_task_deadline.setText(taskDeadline, TextView.BufferType.NORMAL)

        input_task_fab.setOnClickListener {
            val replyIntent = Intent()
            if (TextUtils.isEmpty(edit_task.text)) {
                setResult(Activity.RESULT_CANCELED, replyIntent)
            } else {
                val task = edit_task.text.toString()
                val deadline = edit_task_deadline.text.toString()
                replyIntent.putExtra(EXTRA_REPLY_NAME, task)
                replyIntent.putExtra(EXTRA_REPLY_DATE, deadline)
                setResult(Activity.RESULT_OK, replyIntent)
            }
            finish()
        }
    }
}
