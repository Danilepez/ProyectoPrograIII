package com.example.aaa.dataclasses

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "listas")
data class Lista(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val nombre: String,
    val listaProductos: List<Producto>
)
