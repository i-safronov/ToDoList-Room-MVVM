package com.sfr.domain.use_case.todo

import com.sfr.domain.entity.Todo
import com.sfr.domain.repository.ITodoRepository

class InsertTodoUseCase(
    private val iTodoRepository: ITodoRepository
) {

    suspend fun execute(todo: Todo) {
        iTodoRepository.insert(todo)
    }

}