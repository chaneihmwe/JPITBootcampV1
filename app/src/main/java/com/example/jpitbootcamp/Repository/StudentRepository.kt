package com.example.jpitbootcamp.Repository

import androidx.lifecycle.LiveData
import com.example.jpitbootcamp.DAO.BatchDao
import com.example.jpitbootcamp.DAO.StudentDao
import com.example.jpitbootcamp.Enity.Batch
import com.example.jpitbootcamp.Enity.Student

class StudentRepository (private val studentDao: StudentDao){

    val allStudents: LiveData<List<Student>> = studentDao.getStudentNames()

     suspend fun insert(student: Student) {
        studentDao.insert(student)
    }
}