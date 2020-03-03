package com.example.jpitbootcamp.DataBase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.jpitbootcamp.DAO.BatchDao
import com.example.jpitbootcamp.DAO.StudentDao
import com.example.jpitbootcamp.Enity.Batch
import com.example.jpitbootcamp.Enity.Student
import com.example.jpitbootcamp.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


@Database(entities = arrayOf(Batch::class,Student::class), version = 4,exportSchema = false)
abstract class JPITDatabase : RoomDatabase() {

    abstract fun batchDao(): BatchDao
    abstract fun studentDao(): StudentDao

    companion object {
        //Singleton prevents multiple instance of database opening
        // at the same time

        private var INSTANCE: JPITDatabase? = null

        fun getDatabase(
            context: Context,
            scope: CoroutineScope
        ): JPITDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    JPITDatabase::class.java,
                    "jpit_database"
                )
                    .addCallback(JPITDatabaseCallback(scope))
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
    private class JPITDatabaseCallback(
        private val scope: CoroutineScope
    ) : RoomDatabase.Callback() {

        override fun onOpen(db: SupportSQLiteDatabase) {
            super.onOpen(db)

            INSTANCE?.let { database ->
                scope.launch {
                    populateBatchTable(database.batchDao())
                    populateStudentTable(database.studentDao())
                }
            }
        }

        suspend fun populateBatchTable(batchDao: BatchDao) {

            batchDao.deleteAll()

            var batch = Batch(1,"Batch 1")
            batchDao.insert(batch)
            batchDao.insert(Batch(2,"Batch 2"))
        }

        suspend fun populateStudentTable(studentDao: StudentDao) {

            studentDao.deleteAll()

            var student = Student(1,"Batch 1","Chan Ei Hmwe", R.drawable.avatar)
            studentDao.insert(student)
            studentDao.insert(Student(2,"Batch 2","Min Pike Hmu", R.drawable.avatarboy))
        }
    }
}



