package com.example.diffutilexample

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter

class GroupAdapter : ListAdapter<Group, GroupViewHolder>(LIST_COMPARATOR) {

    companion object {
        private val LIST_COMPARATOR = object : DiffUtil.ItemCallback<Group>() {
            override fun areItemsTheSame(oldItem: Group, newItem: Group): Boolean {
                return ((oldItem.key == newItem.key) && (oldItem.list == newItem.list))
            }

            override fun areContentsTheSame(oldItem: Group, newItem: Group): Boolean {
                return (oldItem == newItem)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroupViewHolder {
        return GroupViewHolder.bindView(parent)
    }

    override fun onBindViewHolder(holder: GroupViewHolder, position: Int) {
        holder.bindItem(getItem(position))
    }
}