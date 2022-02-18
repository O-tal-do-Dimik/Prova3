package com.example.atorapp.repository

import com.example.atorapp.model.Ator
import kotlinx.coroutines.flow.Flow

class AtorRepository(private val atorDAO: AtorDAO) {

    var list:Flow<List<Ator>> = atorDAO.buscarTodos()

    suspend fun cadastrar(f:Ator){
        atorDAO.cadastrar(f)
    }
    suspend fun editar(f: Ator){
        atorDAO.editar(f)
    }
    suspend fun listById(id:Long):Ator{
        return atorDAO.listById(id)

    }
    suspend fun update(f: Ator){
        atorDAO.update(f)
    }
}