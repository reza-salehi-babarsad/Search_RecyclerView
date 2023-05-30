package com.rezoo.search_recyclerview.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "person_tbl")
data class Person(
    @PrimaryKey
    val id:Int,
    val firstName:String,
    val lastName:String,
    val age:Int
)
