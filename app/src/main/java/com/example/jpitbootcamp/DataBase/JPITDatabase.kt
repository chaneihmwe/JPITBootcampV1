package com.example.jpitbootcamp.DataBase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.jpitbootcamp.DAO.BatchDao
import com.example.jpitbootcamp.Enity.Batch


@Database(entities = [(Batch::class)], version = 1)
open abstract class JPITDatabase : RoomDatabase() {
    private var INSTANCE: JPITDatabase? = null

    open fun getInstance(context: Context): JPITDatabase? {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder<JPITDatabase>(
                context.getApplicationContext(),
                JPITDatabase::class.java,
                "jpit_database"
            )
                .build()
        }
        return INSTANCE
    }
    abstract fun batchDao(): BatchDao
}



