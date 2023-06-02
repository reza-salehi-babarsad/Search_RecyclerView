package com.rezoo.search_recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import androidx.activity.viewModels
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.rezoo.search_recyclerview.adapter.MyAdapter
import com.rezoo.search_recyclerview.data.Person
import com.rezoo.search_recyclerview.databinding.ActivityMainBinding
import com.rezoo.search_recyclerview.viewModel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(),SearchView.OnQueryTextListener {
    private lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModels()
    private val myAdapter: MyAdapter by lazy { MyAdapter() }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerview.layoutManager=LinearLayoutManager(this)
        binding.recyclerview.adapter= myAdapter

        //val person=Person(1,"ahmad","salari",32)
       // mainViewModel.insertData(person)
       // val person=Person(2,"ali","karimi",45)
       // mainViewModel.insertData(person)
        val person=Person(3,"nader","farhadi",85)
        mainViewModel.insertData(person)

        mainViewModel.readData.observe(this,{myAdapter.setData(it)})
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.mainmenu,menu)

        val search = menu?.findItem(R.id.menu_search)
        val searchView = search?.actionView as? SearchView
        searchView?.isSubmitButtonEnabled = true
        searchView?.setOnQueryTextListener(this)
        return true
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        if (query!=null){
            searchDatabase(query)
        }
        return true
    }

    override fun onQueryTextChange(query: String?): Boolean {
        if (query!=null){
            searchDatabase(query)
        }
        return true

    }

    fun searchDatabase (query: String?){
        val searchQuery = "%$query%"

        mainViewModel.searchDatabase(searchQuery).observe(this,{ list ->
            list.let {
                myAdapter.setData(it)
            }

        })

    }
}