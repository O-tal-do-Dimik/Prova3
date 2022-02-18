package com.example.atorapp.ui.detalhes

import androidx.lifecycle.*
import com.example.atorapp.model.Ator
import com.example.atorapp.repository.AtorRepository

import kotlinx.coroutines.launch

class DetalhesViewModel(repository: AtorRepository, id: Long) : ViewModel() {

     var ator = MutableLiveData<Ator>()


    init {
        viewModelScope.launch {
            ator.value =  repository.listById(id)
        }
    }



    class Factory(val repository: AtorRepository, val id:Long) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(DetalhesViewModel::class.java)) {
                return DetalhesViewModel(repository, id) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}