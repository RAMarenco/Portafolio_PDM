package com.rmarenco.booktracker.repositories

import com.rmarenco.booktracker.data.dao.BookDao
import com.rmarenco.booktracker.data.models.Author
import com.rmarenco.booktracker.data.models.Book

class BookRepository(private val bookDao: BookDao) {

    fun getBooks() = bookDao.getBooks()

    suspend fun getBooksByIsbn(isbn: String) = bookDao.getBookByIsbn(isbn)
    suspend fun insertBook(book: Book) {
        bookDao.insertBook(book)
    }
}