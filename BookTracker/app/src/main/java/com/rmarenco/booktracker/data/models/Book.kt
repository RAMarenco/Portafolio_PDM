package com.rmarenco.booktracker.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(tableName = "book_table")
data class Book(
    @ColumnInfo(name = "name") val title: String,
    val publicationYear: String,
    val pageCount: Int,
    val subject: String,
    val summary: String,
    val isbn: String,
    val publisherId: Long
) {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0L
    @Ignore
    var authors: List<Author>? = null
}