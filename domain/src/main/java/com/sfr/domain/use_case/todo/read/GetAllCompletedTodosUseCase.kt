package com.sfr.domain.use_case.todo.read

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import com.sfr.domain.entity.Todo
import com.sfr.domain.repository.ITodoRepository

class GetAllCompletedTodosUseCase(
    private val iTodoRepository: ITodoRepository
) {

    fun execute(owner: LifecycleOwner): LiveData<List<Todo>> {
        return iTodoRepository.getAllCompleted(owner)
    }

}