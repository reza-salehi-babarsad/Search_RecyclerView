package com.rezoo.search_recyclerview.di

import android.content.Context
import androidx.room.Room
import com.rezoo.search_recyclerview.data.PersonDao
import com.rezoo.search_recyclerview.data.PersonDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context:Context)=
        Room.databaseBuilder(
            context,
            PersonDatabase::class.java,
            "person_DB"
        ).build()


    @Singleton
    @Provides
    fun provideDao(database:PersonDatabase)= database.personDao()

}