package com.rmarenco.booktracker.data

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.rmarenco.booktracker.data.dao.BookDao
import com.rmarenco.booktracker.data.models.Book
import com.rmarenco.booktracker.data.models.Publisher

@Database(entities = [Book::class, Publisher::class], version = 2)
abstract class BookTrackerDatabase : RoomDatabase() {
    abstract fun bookDao(): BookDao

    companion object {
        private var INSTANCE: BookTrackerDatabase? = null

        fun getInstance(application: Application): BookTrackerDatabase =
            INSTANCE ?: synchronized(this) {
                val instance = Room
                    .databaseBuilder(
                        application.applicationContext,
                        BookTrackerDatabase::class.java,
                        "book_database"
                    )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
    }
}