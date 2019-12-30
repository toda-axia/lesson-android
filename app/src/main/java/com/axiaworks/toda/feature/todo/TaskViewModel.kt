package com.axiaworks.toda.feature.todo

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class TaskViewModel(context: Context) : ViewModel() {

    private val repository: TaskRepository
    val allTasks: LiveData<List<Task>>

    init {
        val tasksDao = TaskDatabase.getDatabase(context, viewModelScope).taskDao()
        repository = TaskRepository(tasksDao)
        allTasks = repository.allTasks
    }

    fun insert(task: Task) = viewModelScope.launch {
        repository.insert(task)
    }
}