package com.axiaworks.toda.feature.todo

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.axiaworks.toda.databinding.TaskItemBinding

class TasksListAdapter(
    private val context: Context,
    private val tasksList: List<Task>,
    private val viewModel: TaskViewModel
    ) : RecyclerView.Adapter<TasksListAdapter.TaskViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val layoutInflater = LayoutInflater.from(context)

        val binding = TaskItemBinding.inflate(layoutInflater, parent, false)
        return TaskViewHolder(binding)
    }

    override fun getItemCount() = tasksList.size

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val data = tasksList[position]
        holder.binding.task = data
        holder.itemView.setOnClickListener {
            viewModel.taskName.value = data.name
            viewModel.taskDeadline.value = data.deadline
            viewModel.editId.value = data.id
        }
    }

    inner class TaskViewHolder(var binding: TaskItemBinding) : RecyclerView.ViewHolder(binding.root)
}