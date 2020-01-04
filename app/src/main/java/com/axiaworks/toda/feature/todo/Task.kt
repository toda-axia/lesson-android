package com.axiaworks.toda.feature.todo

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity (tableName = "task_table")
data class Task(
    @PrimaryKey(autoGenerate = true) val id: Int?,
    val name: String = "",
    val deadline: String? = "",
    val isDone: Boolean = false
)