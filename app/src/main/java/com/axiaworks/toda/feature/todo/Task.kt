package com.axiaworks.toda.feature.todo

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "task_table")
data class Task(
    @PrimaryKey(autoGenerate = true) val id: Int?,
    val name: String = "",
    val isDone: Boolean = false
)