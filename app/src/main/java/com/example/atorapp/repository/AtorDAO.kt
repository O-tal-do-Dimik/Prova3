package com.example.atorapp.repository

import androidx.room.*
import com.example.atorapp.model.Ator
import kotlinx.coroutines.flow.Flow

@Dao
interface AtorDAO {
    @Insert
    suspend fun cadastrar(f: Ator)

    @Update
    suspend fun editar(f: Ator)

    @Delete
    suspend fun excluir(f: Ator)
    @Update
    suspend fun update(f:Ator)

    @Query("SELECT * from Ator")
    fun buscarTodos(): Flow<List<Ator>>

    @Query("SELECT * from ator where id=:id")
    suspend fun listById(id:Long): Ator

    @Query("DELETE FROM Ator")
    fun excluirTodos()

}