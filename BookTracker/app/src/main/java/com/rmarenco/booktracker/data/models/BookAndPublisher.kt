package com.rmarenco.booktracker.data.models

import androidx.room.Embedded
import androidx.room.Relation

data class BookAndPublisher(
    @Relation(
        parentColumn = "id",
        entityColumn = "publisherId"
    )
    val book: Book,
    @Embedded val publisher: Publisher
)