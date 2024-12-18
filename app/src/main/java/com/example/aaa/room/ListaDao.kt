package com.example.aaa.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.example.aaa.dataclasses.Lista
import com.example.aaa.dataclasses.ListaConProductos
import com.example.aaa.dataclasses.Producto

@Dao
interface ListaDao {
    @Insert
    fun insert(lista: Lista)

    @Update
    fun update(lista: Lista)

    @Delete
    fun delete(lista: Lista)

    @Query("SELECT * FROM Listas")
    fun getAllListas(): List<ListaConProductos>  // Devolver la relación con productos

    @Query("SELECT * FROM Listas WHERE lista_id = :id")
    fun getListaById(id: Int): ListaConProductos  // Devolver la relación con productos
}