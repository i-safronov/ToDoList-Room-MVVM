package com.masscode.simpletodolist.di

import android.content.Context
import com.sfr.data.repository.TodoRepository
import com.sfr.data.source.local.LocalDataSource
import com.sfr.data.source.local.room.TodoDb

object Injection {

    fun provideRepository(context: Context): com.sfr.data.repository.TodoRepository {
        val database = com.sfr.data.source.local.room.TodoDb.getInstance(context)

        val localDataSource = com.sfr.data.source.local.LocalDataSource.getInstance(database.todoDAO())

        return com.sfr.data.repository.TodoRepository.getInstance(localDataSource)
    }
}