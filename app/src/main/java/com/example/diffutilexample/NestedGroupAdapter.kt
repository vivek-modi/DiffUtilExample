package com.example.diffutilexample

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter

class NestedGroupAdapter : ListAdapter<Abc, NestedGroupViewHolder>(LIST_COMPARATOR) {

    companion object {
        private val LIST_COMPARATOR = object : DiffUtil.ItemCallback<Abc>() {
            override fun areItemsTheSame(oldItem: Abc, newItem: Abc): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Abc, newItem: Abc): Boolean {
                return (oldItem == newItem)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NestedGroupViewHolder {
        return NestedGroupViewHolder.bindView(parent)
    }

    override fun onBindViewHolder(holder: NestedGroupViewHolder, position: Int) {
        holder.bindItem(getItem(position))
    }
}