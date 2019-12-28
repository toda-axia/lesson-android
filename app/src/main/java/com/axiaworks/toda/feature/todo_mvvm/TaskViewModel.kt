package com.axiaworks.toda.feature.todo_mvvm

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class WordViewModel(application: Application) : AndroidViewModel(application) {

    // The ViewModel maintains a reference to the repository to get data.
    private val repository: TaskRepository
    // LiveData gives us updated words when they change.
    val allTasks: LiveData<List<Task>>

    init {
        // Gets reference to WordDao from WordRoomDatabase to construct
        // the correct WordRepository.
        val wordsDao = TaskDatabase.getDatabase(application).taskDao()
        repository = TaskRepository(wordsDao)
        allTasks = repository.allTasks
    }

    fun insert(word: Task) = viewModelScope.launch {
        repository.insert(word)
    }
}