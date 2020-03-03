package com.example.jpitbootcamp.Enity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "students")
class Student (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo
    var id:Int,
    @ColumnInfo(name = "batch_id")
    var batchId:String,
    @ColumnInfo(name = "student_name")
    var studentName:String,
    @ColumnInfo(name = "student_image")
    var studentImage:Int
)