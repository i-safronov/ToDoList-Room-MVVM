package com.sfr.data.source.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.sfr.data.source.local.entity.TodoEntity

@Database(version = 3, entities = [TodoEntity::class])
abstract class TodoDb : RoomDatabase() {

    abstract fun todoDAO(): TodoDAO

    companion object { // singleton
        @Volatile
        private var INSTANCE: TodoDb? = null

        fun getInstance(context: Context): TodoDb {
            // memastikan dgn synchronize tidak dijalankan secara concurrent / bersamaan langsung
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        TodoDb::class.java,
                        "todo_database"
                    ).fallbackToDestructiveMigration().build()
                    INSTANCE = instance
                }

                return instance
            }
        }
    }

}