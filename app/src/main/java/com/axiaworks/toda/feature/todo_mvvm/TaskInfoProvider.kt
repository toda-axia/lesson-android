package com.axiaworks.toda.feature.todo_mvvm

class TaskInfoProvider {
    companion object {
        var taskList = initTaskList()

        /**
         * Initialises peopleList with dummy data
         */
        private fun initTaskList(): MutableList<Task> {
            var tasks = mutableListOf<Task>()
            tasks.add(Task(
                1,
                "first task",
                false
            ))
            tasks.add(Task(
                2,
                "second task",
                false
            ))
            return tasks
        }
    }
}