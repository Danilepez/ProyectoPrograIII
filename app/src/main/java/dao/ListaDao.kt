package com.example.aaa.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.aaa.dataclasses.Lista

@Dao
interface ListaDao {
    @Insert
    suspend fun insertarLista(lista: Lista)

    @Query("SELECT * FROM listas")
    suspend fun obtenerListas(): List<Lista>
}
