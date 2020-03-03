package com.example.jpitbootcamp.Enity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "batches")
class Batch (
    @PrimaryKey(autoGenerate = true)
    var id:Int,
    @ColumnInfo(name = "batch_name")
    var batchName:String
)