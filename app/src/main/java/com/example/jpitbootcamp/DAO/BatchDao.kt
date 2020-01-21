package com.example.jpitbootcamp.DAO

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.jpitbootcamp.Enity.Batch

@Dao
interface BatchDao {
    @Query("SELECT * FROM batch")
    fun getBatchNames():List<Batch>
    @Insert
    fun insert(batch: Batch)
    @Query("DELETE FROM batch")
    fun deleteAll()
}