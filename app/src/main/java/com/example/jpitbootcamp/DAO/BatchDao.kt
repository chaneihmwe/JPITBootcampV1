package com.example.jpitbootcamp.DAO

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.jpitbootcamp.Enity.Batch


@Dao
interface BatchDao {
    @Query("SELECT * FROM batches")
    fun getBatchNames():LiveData<List<Batch>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(batch: Batch)

    @Query("DELETE FROM batches")
    suspend fun deleteAll()

    @Query("DELETE FROM batches WHERE id = :batchId")
    fun deleteBatchById(batchId: Long)
}