package com.sfr.data.source.local

import androidx.lifecycle.LiveData
import com.sfr.data.source.local.entity.TodoEntity
import com.sfr.data.source.local.room.TodoDAO

class LocalDataSource private constructor(private val todoDAO: TodoDAO) {

    companion object {
        private var INSTANCE: LocalDataSource? = null

        fun getInstance(todoDAO: TodoDAO): LocalDataSource =
            INSTANCE ?: LocalDataSource(todoDAO)
    }

    fun getAllTodos(): LiveData<List<TodoEntity>> = todoDAO.loadTodos()

    fun getAllCompleted(): LiveData<List<TodoEntity>> = todoDAO.loadCompleted()

    suspend fun insert(todoEntity: TodoEntity) = todoDAO.insertTodo(todoEntity)

    suspend fun update(todoEntity: TodoEntity) = todoDAO.updateTodo(todoEntity)

    suspend fun deleteSelectedTodos() = todoDAO.deleteSelectedTodos()

    suspend fun clearTodos() = todoDAO.clearTodos()
}