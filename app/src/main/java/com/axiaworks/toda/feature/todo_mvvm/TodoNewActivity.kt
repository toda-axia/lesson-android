package com.axiaworks.toda.feature.todo_mvvm

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.EditText
import com.axiaworks.toda.R
import kotlinx.android.synthetic.main.activity_todo_new.*

class TodoNewActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_REPLY = "com.axiaworks.toda.feature.todo_mvvm.REPLY"
        fun callingIntent(context: Context) = Intent(context, TodoNewActivity::class.java)
    }
    private lateinit var editTaskView: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo_new)
        editTaskView = findViewById(R.id.edit_task)

        input_task_fab.setOnClickListener {
            val replyIntent = Intent()
            if (TextUtils.isEmpty(editTaskView.text)) {
                setResult(Activity.RESULT_CANCELED, replyIntent)
            } else {
                val task = editTaskView.text.toString()
                replyIntent.putExtra(EXTRA_REPLY, task)
                setResult(Activity.RESULT_OK, replyIntent)
            }
            finish()
        }
    }
}
