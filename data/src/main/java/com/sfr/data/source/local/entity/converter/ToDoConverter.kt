package com.sfr.data.source.local.entity.converter

import com.sfr.data.source.local.entity.TodoEntity
import com.sfr.domain.entity.Todo

object ToDoConverter {

    fun convertTodoToTodoEntity(
        todo: Todo
    ): TodoEntity {
        return TodoEntity(
            id = todo.id,
            title = todo.title,
            description = todo.description,
            checked = todo.checked
        )
    }

    fun convertTodoEntityToTodo(
        todoEntity: TodoEntity
    ): Todo {
        return Todo(
            id = todoEntity.id,
            title = todoEntity.title,
            description = todoEntity.description,
            checked = todoEntity.checked
        )
    }

    fun convertListOfTodoEntityToListOfTodo(
        list: List<TodoEntity>
    ): List<Todo> {
        val mList = mutableListOf<Todo>()
        list.forEach {
            mList.add(ToDoConverter.convertTodoEntityToTodo(it))
        }
        return mList.toList()
    }

}