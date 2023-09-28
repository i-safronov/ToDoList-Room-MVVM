package com.sfr.domain.use_case.todo

import com.sfr.domain.repository.ITodoRepository

class DeleteSelectedTodosUseCase(
    private val iTodoRepository: ITodoRepository
) {

    suspend fun deleteSelectedTodos() {
        iTodoRepository.deleteSelectedTodos()
    }

}