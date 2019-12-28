package com.axiaworks.toda.feature.todo_mvvm

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "task_table")
data class Task(
    @PrimaryKey @ColumnInfo(name = "task") val task: String
//    @PrimaryKey(autoGenerate = true) var id: Int = 0,
//    var name: String = "",
//    var isDone: Boolean = false
)