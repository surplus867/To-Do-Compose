package com.example.to_do_compose.data.models

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.to_do_compose.data.ToDoDao


@Database(entities = [ToDoTask::class], version = 1, exportSchema = false)
abstract class ToDoDatabase: RoomDatabase() {

    abstract fun toDoDao(): ToDoDao
}