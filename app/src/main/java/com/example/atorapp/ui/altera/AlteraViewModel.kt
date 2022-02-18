package com.example.atorapp.ui.altera

import androidx.lifecycle.ViewModel

import androidx.lifecycle.*
import com.example.atorapp.model.Ator
import com.example.atorapp.repository.AtorRepository

import kotlinx.coroutines.launch

class AlteraViewModel(val repository: AtorRepository, id:Long) : ViewModel()  {

    var ator = MutableLiveData<Ator>()

    private var _eventAlteraAtor = MutableLiveData<Boolean>(false)
    val eventAlteraFilme:LiveData<Boolean>
        get() = _eventAlteraAtor


    init {
        viewModelScope.launch {
            ator.value =  repository.listById(id)
        }
    }

    fun onAlteraAtorStart(){

        viewModelScope.launch {
            repository.editar(ator.value!!)
        }
        _eventAlteraAtor.value = true
    }

    fun onAlteraFilmeCompleto(){
        _eventAlteraAtor.value = false
    }

    class Factory(val repository: AtorRepository, val id: Long) : ViewModelProvider.Factory{
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(AlteraViewModel::class.java)) {
                return AlteraViewModel(repository, id) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}