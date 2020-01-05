package com.axiaworks.toda.feature.todo

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.axiaworks.toda.R
import kotlinx.android.synthetic.main.activity_todo.*
import org.koin.android.viewmodel.ext.android.viewModel
import java.text.SimpleDateFormat
import java.util.*

class TodoActivity : AppCompatActivity() {
    companion object {
        fun callingIntent(context: Context) = Intent(context, TodoActivity::class.java)
    }
    private val todoNewActivityRequestCode = 1
    private val todoNewActivityRequestEditCode = 2
    private val taskViewModel: TaskViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo)

        taskViewModel.allTasks.observe(this, Observer {
            task_recyclerview.adapter = TasksListAdapter(this, it, taskViewModel)
        })
        task_recyclerview.layoutManager = LinearLayoutManager(this)

        add_task_fab.setOnClickListener {
            startActivityForResult(
                TodoNewActivity.callingIntent(
                    this,
                    "",
                    SimpleDateFormat("yyyy-MM-dd").format(Date())),
                todoNewActivityRequestCode)
        }

        taskViewModel.editId.observe(this, Observer {
            it?.let {
                if (it != 0) {
                    startActivityForResult(TodoNewActivity.callingIntent(
                        this,
                        taskViewModel.taskName.value,
                        taskViewModel.taskDeadline.value),
                        todoNewActivityRequestEditCode)
                }
            }
        })
    }

    // https://developer.android.com/training/basics/intents/result?hl=ja
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == todoNewActivityRequestCode && resultCode == Activity.RESULT_OK) {
            data?.getStringExtra(TodoNewActivity.EXTRA_REPLY_NAME)?.let { taskName ->
                data?.getStringExtra(TodoNewActivity.EXTRA_REPLY_DATE)?.let { taskDate ->
                    val task = Task(null, taskName, taskDate,false)
                    taskViewModel.insert(task)
                }
            }
        } else if (requestCode == todoNewActivityRequestEditCode && resultCode == Activity.RESULT_OK) {
            data?.getStringExtra(TodoNewActivity.EXTRA_REPLY_NAME)?.let {
                val task = Task(taskViewModel.editId.value, it, "",false)
                taskViewModel.insert(task)
            }
        } else {
            Toast.makeText(
                applicationContext,
                R.string.empty_not_saved,
                Toast.LENGTH_LONG).show()
        }
    }
}
