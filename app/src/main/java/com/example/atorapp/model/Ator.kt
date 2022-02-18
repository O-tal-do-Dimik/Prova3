package com.example.atorapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Ator (
    var nome: String,
    var nacionalidade: String,
    var nacimento: String,
    var indicacao: String,
    var idade: Int,
    var oscar: Int
){
    @PrimaryKey(autoGenerate = true)
    var id = 0L
    constructor():this("","","","",0,0)
    fun converterAnoString():String{
        return oscar.toString()

    }
}

