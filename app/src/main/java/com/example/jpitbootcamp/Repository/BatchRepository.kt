package com.example.jpitbootcamp.Repository

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.jpitbootcamp.DAO.BatchDao
import com.example.jpitbootcamp.Enity.Batch

class BatchRepository (private val batchDao: BatchDao){

    val allBatches: LiveData<List<Batch>> = batchDao.getBatchNames()

    suspend fun insert(batch:Batch) {
        Log.d("BatchRepo", batch.toString())
        batchDao.insert(batch)
    }
}