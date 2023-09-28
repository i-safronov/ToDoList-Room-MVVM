package com.sfr.domain.entity

data class Todo(
    var id: Int,
    var title: String,
    var description: String,
    var checked: Boolean
): java.io.Serializable