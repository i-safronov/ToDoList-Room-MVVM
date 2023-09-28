package com.masscode.simpletodolist.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.sfr.data.repository.TodoRepository
import com.sfr.data.source.local.entity.Todo
import com.masscode.simpletodolist.di.Injection
import kotlinx.coroutines.launch

class TodoViewModel(private val repository: com.sfr.data.repository.TodoRepository): ViewModel() {

    fun getAllTodos(): LiveData<List<com.sfr.data.source.local.entity.Todo>> = repository.getAllTodos()

    fun getAllCompleted(): LiveData<List<com.sfr.data.source.local.entity.Todo>> = repository.getAllCompleted()

    fun addTodo(title: String, desc: String) {
        viewModelScope.launch {
            repository.insert(com.sfr.data.source.local.entity.Todo(0, title, desc, false))
        }
    }

    fun updateTodo(id: Int, title: String, desc: String, checked: Boolean) {
        viewModelScope.launch {
            repository.update(com.sfr.data.source.local.entity.Todo(id, title, desc, checked))
        }
    }

    fun deleteSelected() {
        viewModelScope.launch {
            repository.deleteSelectedTodos()
        }
    }

    fun clearTodos() {
        viewModelScope.launch {
            repository.clearTodos()
        }
    }
}

class TodoViewModelFactory(private val mTodoRepository: TodoRepository) :
    ViewModelProvider.NewInstanceFactory() {

    companion object {
        @Volatile
        private var instance: TodoViewModelFactory? = null

        fun getInstance(context: Context): TodoViewModelFactory =
            instance ?: synchronized(this) {
                instance ?: TodoViewModelFactory(Injection.provideRepository(context))
            }
    }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return TodoViewModel(mTodoRepository) as T
    }

}