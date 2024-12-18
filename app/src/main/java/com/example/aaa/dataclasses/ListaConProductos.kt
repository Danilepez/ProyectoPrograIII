package com.example.aaa.dataclasses

import androidx.room.Embedded
import androidx.room.Relation

data class ListaConProductos (
    @Embedded
    val lista: Lista, // Datos de la lista
    @Relation(
        parentColumn = "id", // Columna en la tabla Listas
        entityColumn = "listaId" // Clave foránea en la tabla Productos
    )
    val productos: List<Producto> // Lista de productos asociados
)