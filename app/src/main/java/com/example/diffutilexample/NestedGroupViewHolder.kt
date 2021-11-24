package com.example.diffutilexample

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.diffutilexample.databinding.NestedItemLayoutBinding

class NestedGroupViewHolder(val binding: NestedItemLayoutBinding) :
    RecyclerView.ViewHolder(binding.root) {

    companion object {
        fun bindView(parent: ViewGroup): NestedGroupViewHolder {
            return NestedGroupViewHolder(
                NestedItemLayoutBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        }
    }

    fun bindItem(item: Abc?) {
        binding.text.text = item?.qwe?.firstName
    }
}