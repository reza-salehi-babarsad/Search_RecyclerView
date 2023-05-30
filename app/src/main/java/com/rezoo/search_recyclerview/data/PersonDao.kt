package com.rezoo.search_recyclerview.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface PersonDao {
    @Query("SELECT * FROM person_tbl ORDER BY  id ASC")
    fun getAllPerson(): Flow<List<Person>>

     @Upsert
     suspend fun InsertPerson(person: Person)


     @Query("SELECT * FROM person_tbl WHERE firstName LIKE :searchQuery OR lastName LIKE :searchQuery")
     fun searchDatabase(searchQuery: String) : Flow<List<Person>>
}