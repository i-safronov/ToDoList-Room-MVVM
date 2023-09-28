package com.sfr.domain.repository

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import com.sfr.domain.entity.Todo

interface ITodoRepository {

    fun getAllTodos(owner: LifecycleOwner): LiveData<List<Todo>>
    fun getAllCompleted(owner: LifecycleOwner): LiveData<List<Todo>>
    suspend fun insert(todo: Todo)
    suspend fun update(todo: Todo)
    suspend fun deleteSelectedTodos()
    suspend fun clearTodos()

}