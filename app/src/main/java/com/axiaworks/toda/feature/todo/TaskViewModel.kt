package com.axiaworks.toda.feature.todo

import android.app.Application
import android.content.Context
import androidx.lifecycle.*
import kotlinx.coroutines.launch

class TaskViewModel(context: Context) : ViewModel() {

    private val repository: TaskRepository
    val allTasks: LiveData<List<Task>>
    val editId: MutableLiveData<Int> = MutableLiveData(0)
    val taskName: MutableLiveData<String> = MutableLiveData("")
    val taskDeadline: MutableLiveData<String> = MutableLiveData("")

    init {
        val tasksDao = TaskDatabase.getDatabase(context, viewModelScope).taskDao()
        repository = TaskRepository(tasksDao)
        allTasks = repository.allTasks
    }

    fun insert(task: Task) = viewModelScope.launch {
        repository.insert(task)
    }

    fun update(task: Task) = viewModelScope.launch {
        repository.update(task)
    }
}