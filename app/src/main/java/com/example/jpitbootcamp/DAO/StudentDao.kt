package com.example.jpitbootcamp.DAO

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.jpitbootcamp.Enity.Student

@Dao
interface StudentDao {
    @Query("SELECT * FROM students")
    fun getStudentNames(): LiveData<List<Student>>
    @Insert
    suspend fun insert(student:Student)
    @Query("DELETE FROM students")
    suspend fun deleteAll()
}