package com.sfr.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.sfr.data.source.local.entity.TodoEntity

@Dao
interface TodoDAO {
    @Query("SELECT * FROM ${TodoEntity.TABLE_NAME}")
    fun loadTodos(): LiveData<List<TodoEntity>>

    @Query("SELECT * FROM ${TodoEntity.TABLE_NAME} WHERE checked = 1")
    fun loadCompleted(): LiveData<List<TodoEntity>>

    @Insert
    suspend fun insertTodo(todoEntity: TodoEntity)

    @Update
    suspend fun updateTodo(todoEntity: TodoEntity)

    @Delete
    suspend fun deleteTodo(todoEntity: TodoEntity)

    @Query("DELETE FROM ${TodoEntity.TABLE_NAME} WHERE checked = 1")
    suspend fun deleteSelectedTodos()

    @Query("DELETE FROM ${TodoEntity.TABLE_NAME}")
    suspend fun clearTodos()
}