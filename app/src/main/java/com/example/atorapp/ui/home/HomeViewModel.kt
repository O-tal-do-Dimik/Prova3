package com.example.atorapp.ui.home

import androidx.lifecycle.*
import com.example.atorapp.model.Ator
import com.example.atorapp.repository.AtorRepository


class HomeViewModel(repository: AtorRepository) : ViewModel() {
    var list:LiveData<List<Ator>> = repository.list.asLiveData()

    class Factory(val repository: AtorRepository) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
                return HomeViewModel(repository) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")

        }

    }

}