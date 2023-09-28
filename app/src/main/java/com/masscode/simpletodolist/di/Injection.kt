package com.masscode.simpletodolist.di

import android.content.Context
import com.sfr.data.repository.TodoRepository

object Injection {

    fun provideRepository(context: Context): TodoRepository {
        val database = com.sfr.data.source.local.room.TodoDb.getInstance(context)

        val localDataSource = com.sfr.data.source.local.LocalDataSource.getInstance(database.todoDAO())

        return TodoRepository.getInstance(localDataSource)
    }
}