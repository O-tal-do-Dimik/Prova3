package com.example.atorapp.repository

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.atorapp.model.Ator


@Database(entities = [Ator::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun atorDAO(): AtorDAO

    companion object {
        @Volatile private var instance: AppDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context)= instance ?: synchronized(LOCK){
            instance ?: buildDatabase(context).also { instance = it}
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(context,
            AppDatabase::class.java, "ator.sqlite")
            .fallbackToDestructiveMigration()
            .build()
    }
}