package com.rezoo.search_recyclerview.data

import androidx.room.Database

@Database(
    entities = [Person::class],
    version = 1,
    exportSchema = false)
abstract class PersonDatabase {
     abstract fun personDao():PersonDao
}