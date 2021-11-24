package com.example.diffutilexample

data class GroupKey(
    val qwe: Qwe? = null
)

data class Group(
    val key: GroupKey,
    val list: MutableList<Abc?> = ArrayDeque()
)

data class Abc(
    val type: String? = null,
    val text: String? = null,
    var qwe: Qwe? = null,
    val tyz: Tyz? = null,
    val id: String? = null
)

data class Qwe(
    val firstName: String? = null,
    val lastName: String? = null,
    val tyz: Tyz? = null,
    val id: String? = null
)

data class Tyz(
    val id: String? = null,
    val name: String? = null
)

data class MainResponse(
    val id: String? = null,
    val title: String? = null,
    val createdAt: String? = null,
    val abc: List<Abc>? = null
)


