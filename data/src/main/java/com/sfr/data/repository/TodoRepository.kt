package com.sfr.data.repository

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sfr.data.source.local.LocalDataSource
import com.sfr.data.source.local.entity.TodoEntity
import com.sfr.data.source.local.entity.converter.ToDoConverter
import com.sfr.domain.entity.Todo
import com.sfr.domain.repository.ITodoRepository

class TodoRepository(
    private val localDataSource: LocalDataSource
) : ITodoRepository {

    companion object {
        @Volatile
        private var instance: TodoRepository? = null

        fun getInstance(localData: LocalDataSource): TodoRepository =
            instance ?: synchronized(this) {
                instance ?: TodoRepository(localData)
            }
    }

    override fun getAllTodos(owner: LifecycleOwner): LiveData<List<Todo>> {
        val mLiveData = MutableLiveData<List<Todo>>()
        localDataSource.getAllTodos().observe(owner) {
            mLiveData.postValue(ToDoConverter.convertListOfTodoEntityToListOfTodo(it))
        }
        return mLiveData
    }

    override fun getAllCompleted(owner: LifecycleOwner): LiveData<List<Todo>> {
        val mLiveData = MutableLiveData<List<Todo>>()
        localDataSource.getAllCompleted().observe(owner) {
            mLiveData.postValue(ToDoConverter.convertListOfTodoEntityToListOfTodo(it))
        }
        return mLiveData
    }

    override suspend fun insert(todo: Todo) {
        localDataSource.insert(ToDoConverter.convertTodoToTodoEntity(todo))
    }

    override suspend fun update(todo: Todo) {
        localDataSource.update(ToDoConverter.convertTodoToTodoEntity(todo))
    }

    override suspend fun deleteSelectedTodos() {
        localDataSource.deleteSelectedTodos()
    }

    override suspend fun clearTodos() {
        localDataSource.clearTodos()
    }

}