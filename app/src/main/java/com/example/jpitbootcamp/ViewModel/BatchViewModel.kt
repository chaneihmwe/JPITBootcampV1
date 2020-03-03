package com.example.jpitbootcamp.ViewModel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.jpitbootcamp.DataBase.JPITDatabase
import com.example.jpitbootcamp.Enity.Batch
import com.example.jpitbootcamp.Enity.Student
import com.example.jpitbootcamp.Repository.BatchRepository
import kotlinx.coroutines.launch

//Class extends AndroidViewModel and requires application as a parameter
class BatchViewModel(application: Application) : AndroidViewModel(application) {

    //The ViewModel maintains a reference to the repository to get data
    private val repository: BatchRepository
    //LiveData gives us updated words when they change
    val allBatches: LiveData<List<Batch>>

    private var deletedBatch: MutableLiveData<Student> = MutableLiveData()
    fun getDeletedBatch():LiveData<Student> = deletedBatch
    fun  deletedBatch(student: Student){
        deletedBatch.value = student
        Log.d("DeletedStudent", student.toString())
    }

    init {

        val batchDao = JPITDatabase
            .getDatabase(application,viewModelScope)
            .batchDao()
        repository = BatchRepository(batchDao)
        allBatches = repository.allBatches
    }

    //to handle the background task
    fun insert(batch: Batch) = viewModelScope.launch {
        Log.d("BatchViewModel", batch.toString())
        repository.insert(batch)
    }


}