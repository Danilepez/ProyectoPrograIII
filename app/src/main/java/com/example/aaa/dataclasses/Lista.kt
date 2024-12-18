package com.example.aaa.dataclasses

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Listas")
data class Lista(
    @PrimaryKey(autoGenerate = true) val lista_id: Int = 0, // Clave primaria
    val nombre: String
)