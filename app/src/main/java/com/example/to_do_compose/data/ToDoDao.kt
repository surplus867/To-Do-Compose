package com.example.to_do_compose.data

import androidx.room.*
import com.example.to_do_compose.data.models.ToDoTask
import kotlinx.coroutines.flow.Flow

@Dao
interface ToDoDao {

    @Query("SELECT * FROM todo_table ORDER BY id ASC")
    fun getAllTasks(): Flow<List<ToDoTask>>

    @Query("SELECT * FROM todo_table WHERE id=:taskId")
    fun getSelectedTask(taskId: Int): Flow<ToDoTask>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addTask(toDoTask: ToDoTask)

    @Update
    suspend fun updateTask(toDoTask: ToDoTask)

    @Delete
    suspend fun deleteTask(toDoTask: ToDoTask)

    @Query("DELETE FROM todo_table")
    suspend fun deleteAllTask()

    @Query("SELECT * FROM todo_table WHERE title LIKE :searchQuery OR description LIKE :searchQuery")
    fun searchDatabase(searchQuery: String): Flow<List<ToDoTask>>

    @Query("SELECT * FROM todo_table ORDER By CASE When priority LIKE 'L%' " +
            "THEN 1 WHEN priority LIKE 'M%' THEN 2 WHEN priority LIKE 'H%' Then 3 END" )
    fun sortByLowPriority(): Flow<List<ToDoTask>>

    @Query("SELECT * FROM todo_table ORDER By CASE When priority LIKE 'H%' " +
            "THEN 1 WHEN priority LIKE 'M%' THEN 2 WHEN priority LIKE 'L%' Then 3 END" )
    fun sortByHighPriority(): Flow<List<ToDoTask>>
}