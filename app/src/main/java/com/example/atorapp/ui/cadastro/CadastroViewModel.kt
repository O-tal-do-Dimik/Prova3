package com.example.atorapp.ui.cadastro
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import com.example.atorapp.model.Ator
import com.example.atorapp.repository.AppDatabase

import kotlinx.coroutines.launch

class CadastroViewModel(application: Application) : AndroidViewModel(application) {

    private val _eventCadastrarAtor = MutableLiveData<Boolean>(false)
    val eventCadastrarAtor: LiveData<Boolean>
        get() = _eventCadastrarAtor


    var ator = Ator()

    private val db: AppDatabase by lazy {
        Room.databaseBuilder(
            application.applicationContext,
            AppDatabase::class.java,
            "ator.sqlite")
            .build()
    }

    fun onCadastraAtorStart(){
        viewModelScope.launch {
            db.atorDAO().cadastrar(ator)
        }
        _eventCadastrarAtor.value = true
    }
    fun CadastraAtorComplete(){
        _eventCadastrarAtor.value = false
    }

}