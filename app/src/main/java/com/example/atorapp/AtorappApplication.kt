package com.example.atorapp

import android.app.Application
import com.example.atorapp.repository.AppDatabase
import com.example.atorapp.repository.AtorRepository

class AtorappApplication: Application() {


    val database by lazy { AppDatabase.invoke(this) }
    val atorRepository by lazy { AtorRepository(database.atorDAO()) }
}
