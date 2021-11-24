package com.example.diffutilexample

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.diffutilexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val viewModel by viewModels<ActivityViewModel>()
    private lateinit var binding: ActivityMainBinding
    private var groupAdapter: GroupAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupViewModel()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel.fetchData()

        binding.button.setOnClickListener {
            viewModel.addData()
        }
    }

    private fun setupViewModel() {
        viewModel.groupListLiveData.observe(this) {
            if (groupAdapter == null) {
                groupAdapter = GroupAdapter()
                binding.recyclerview.adapter = groupAdapter
            }
            groupAdapter?.submitList(viewModel.groupList?.toMutableList())
            binding.recyclerview.post {
                groupAdapter?.notifyDataSetChanged()
            }
        }
    }
}