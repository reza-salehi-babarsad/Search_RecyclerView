package com.rezoo.search_recyclerview.data

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PersonRepository @Inject constructor(
    private val personDao: PersonDao
) {
    fun readData():Flow<List<Person>> =personDao.getAllPerson()
    suspend fun insertData(person: Person){
        personDao.InsertPerson(person)
    }
    fun searchDatabase(searchQuery:String):Flow<List<Person>> =
        personDao.searchDatabase(searchQuery)
}