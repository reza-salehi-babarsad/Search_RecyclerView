package com.rezoo.search_recyclerview.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rezoo.search_recyclerview.data.Person
import com.rezoo.search_recyclerview.databinding.RowLayoutBinding

class MyAdapter:RecyclerView.Adapter<MyAdapter.ViewHolder>() {
    private var oldData = emptyList<Person>()
    class ViewHolder(val binding: RowLayoutBinding ):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       return ViewHolder(
           RowLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
       )
    }

    override fun getItemCount(): Int =
        oldData.size


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.ageTextView.text=oldData[position].age.toString()
        holder.binding.firstNameTextView.text=oldData[position].firstName
        holder.binding.lastNameTextView.text=oldData[position].lastName
    }
    fun setData(newData: List<Person>){
        oldData = newData
        notifyDataSetChanged()
    }
}