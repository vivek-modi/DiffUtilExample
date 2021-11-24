package com.example.diffutilexample

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.diffutilexample.databinding.ItemLayoutBinding

class GroupViewHolder(val binding: ItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {

    companion object {
        fun bindView(parent: ViewGroup): GroupViewHolder {
            return GroupViewHolder(
                ItemLayoutBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        }
    }

    fun bindItem(item: Group?) {
        val nestedGroupAdapter = NestedGroupAdapter()
        binding.nestedRecyclerview.adapter = nestedGroupAdapter
        if (item != null) {
            nestedGroupAdapter.submitList(item.list.toMutableList())
        }
    }
}