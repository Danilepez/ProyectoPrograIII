package com.example.aaa.dataclasses

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "productos")
data class Producto(
    @PrimaryKey(autoGenerate = false)
    val nombre: String,
    val fechaVencimiento: String,
    val estado: String,
    val lista: String,
    val cantidad: Int,
    val Imagen: Int
)
