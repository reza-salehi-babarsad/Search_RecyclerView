package com.rezoo.search_recyclerview.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import androidx.room.Query
import com.rezoo.search_recyclerview.data.Person
import com.rezoo.search_recyclerview.data.PersonRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: PersonRepository
) : ViewModel() {
    val readData = repository.readData().asLiveData()

    fun insertData(person: Person) {
        viewModelScope.launch {
            repository.insertData(person)
        }
    }

    fun searchDatabase(searchQuery: String):LiveData<List<Person>>{
        return repository.searchDatabase(searchQuery).asLiveData()

    }
}