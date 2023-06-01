package com.rezoo.search_recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.rezoo.search_recyclerview.adapter.MyAdapter
import com.rezoo.search_recyclerview.data.Person
import com.rezoo.search_recyclerview.databinding.ActivityMainBinding
import com.rezoo.search_recyclerview.viewModel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModels()
    private val myAdapter: MyAdapter by lazy { MyAdapter() }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerview.layoutManager=LinearLayoutManager(this)
        binding.recyclerview.adapter= myAdapter

        val person=Person(1,"ahmad","salari",32)
        mainViewModel.insertData(person)

        mainViewModel.readData.observe(this,{myAdapter.setData(it)})
    }
}