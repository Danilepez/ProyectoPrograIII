package com.example.aaa.dataclasses

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey


@Entity(
    tableName = "Productos",
    foreignKeys = [
        ForeignKey(
            entity = Lista::class,
            parentColumns = ["id"],
            childColumns = ["lista_id"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index(value = ["lista_id"])]
)

data class Producto(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val nombre: String,
    var fechaVencimiento: String,
    var estado: String,
    var cantidad: Int,
    val imagen: Int,
    @ColumnInfo(name = "lista_id") val listaId: Int // ID de la lista relacionada
)