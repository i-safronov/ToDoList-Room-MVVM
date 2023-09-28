package com.sfr.domain.use_case.todo.delete

import com.sfr.domain.repository.ITodoRepository

class ClearTodosUseCase(
    private val iTodoRepository: ITodoRepository
) {

    suspend fun execute() {
        iTodoRepository.clearTodos()
    }

}