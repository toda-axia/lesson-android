package com.axiaworks.toda.feature.todo

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import com.axiaworks.toda.R
import kotlinx.android.synthetic.main.activity_todo_new.*
import org.koin.android.viewmodel.ext.android.viewModel

class TodoNewActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_REPLY = "com.axiaworks.toda.feature.todo_mvvm.REPLY"
        fun callingIntent(context: Context) = Intent(context, TodoNewActivity::class.java)
    }
    private val taskViewModel: TaskViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo_new)

        input_task_fab.setOnClickListener {
            val replyIntent = Intent()
            if (TextUtils.isEmpty(edit_task.text)) {
                setResult(Activity.RESULT_CANCELED, replyIntent)
            } else {
                taskViewModel.taskName.value = edit_task.text.toString()
                replyIntent.putExtra(EXTRA_REPLY, taskViewModel.taskName.value)
                setResult(Activity.RESULT_OK, replyIntent)
            }
            finish()
        }
    }
}
