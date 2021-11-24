package com.example.diffutilexample

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class ActivityViewModel(app: Application) : AndroidViewModel(app) {

    var groupListLiveData: MutableLiveData<Boolean> = MutableLiveData()
    var groupList: ArrayDeque<Group>? = null
        set(value) {
            field = value
            groupListLiveData.postValue(true)
        }
    var value = 0

    fun fetchData() {
        viewModelScope.launch {
            val response = ApiInterface.create().getResponse()

            groupList = groupByData(response.abc)
        }
    }

    private fun groupByData(abc: List<Abc>?): ArrayDeque<Group> {
        val result: ArrayDeque<Group> = groupList ?: ArrayDeque()

        abc?.iterator()?.forEach { item ->
            val key = GroupKey(item.qwe)
            result.addFirst(Group(key, mutableListOf(item)))
        }
        return result
    }

    fun addData() {
        groupList?.let { lastList ->
            val qwe = Qwe("Vivek ${value++}", "Modi")
            val item = Abc(type = "Type 1", "Adding Message", qwe)
            val lastGroup = lastList[0]
            lastGroup.list.add(item)
            groupList = lastList
        }
    }
}
