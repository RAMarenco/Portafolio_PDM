package com.rmarenco.booktracker

import android.app.Application
import com.rmarenco.booktracker.data.BookTrackerDatabase
import com.rmarenco.booktracker.repositories.BookRepository

class BookTrackerApplication : Application() {
    private val db: BookTrackerDatabase by lazy {
        BookTrackerDatabase.getInstance(this)
    }
    val bookRepository: BookRepository by lazy {
        BookRepository(db.bookDao())
    }
}