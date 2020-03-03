package com.example.jpitbootcamp.ViewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.jpitbootcamp.Enity.Student


class StudentDetailViewModel : ViewModel() {

    private var selectedStudent: MutableLiveData<Student> = MutableLiveData()
    fun getSelectedStudent():LiveData<Student> = selectedStudent
    fun  selectedStudent(student: Student){
        selectedStudent.value = student
        Log.d("SelectedStudent", student.toString())
    }
}