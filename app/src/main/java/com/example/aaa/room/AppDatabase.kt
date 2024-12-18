package com.example.aaa.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.aaa.dataclasses.Lista
import com.example.aaa.dataclasses.Producto

@Database(
    entities = [Lista::class, Producto::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun listaDao(): ListaDao
    abstract fun productoDao(): ProductoDao
}