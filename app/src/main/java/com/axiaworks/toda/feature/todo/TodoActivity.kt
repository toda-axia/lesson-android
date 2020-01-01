package com.axiaworks.toda.feature.todo

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.axiaworks.toda.R
import kotlinx.android.synthetic.main.activity_todo.*
import org.koin.android.viewmodel.ext.android.viewModel

class TodoActivity : AppCompatActivity() {
    companion object {
        fun callingIntent(context: Context) = Intent(context, TodoActivity::class.java)
    }
    private val todoNewActivityRequestCode = 1
    private val taskViewModel: TaskViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo)

        taskViewModel.allTasks.observe(this, Observer {
            task_recyclerview.adapter = TasksListAdapter(this, it, taskViewModel)
        })
        task_recyclerview.layoutManager = LinearLayoutManager(this)

        add_task_fab.setOnClickListener {
            startActivityForResult(TodoNewActivity.callingIntent(this), todoNewActivityRequestCode)
        }

        taskViewModel.editMode.observe(this, Observer {
            it?.let {
                if (it) {
                    startActivityForResult(TodoNewActivity.callingIntent(this), todoNewActivityRequestCode)
                }
            }
        })
    }

    // https://developer.android.com/training/basics/intents/result?hl=ja
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == todoNewActivityRequestCode && resultCode == Activity.RESULT_OK) {
            data?.getStringExtra(TodoNewActivity.EXTRA_REPLY)?.let {
                val task = Task(null, it, false)
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
