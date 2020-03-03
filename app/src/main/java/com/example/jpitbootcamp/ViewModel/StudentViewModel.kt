package com.example.jpitbootcamp.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.jpitbootcamp.DataBase.JPITDatabase
import com.example.jpitbootcamp.Enity.Student
import com.example.jpitbootcamp.Repository.StudentRepository
import kotlinx.coroutines.launch

//Class extends AndroidViewModel and requires application as a parameter
class StudentViewModel(application: Application) : AndroidViewModel(application) {

    //The ViewModel maintains a reference to the repository to get data
    private val repository: StudentRepository
    //LiveData gives us updated words when they change
    val allStudents: LiveData<List<Student>>

    init {
        val studentDao = JPITDatabase
            .getDatabase(application,viewModelScope)
            .studentDao()
        repository = StudentRepository(studentDao)
        allStudents = repository.allStudents
    }

    //to handle the background task
    fun insert(student: Student)  = viewModelScope.launch {
        repository.insert(student)
    }
}