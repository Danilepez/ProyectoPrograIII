package com.example.aaa.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.OnConflictStrategy
import com.example.aaa.dataclasses.Producto

@Dao
interface ProductoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertarProducto(producto: Producto)

    @Query("SELECT * FROM Productos WHERE nombre = :nombre AND fechaVencimiento = :fechaVencimiento")
    suspend fun obtenerProductoPorNombreYFecha(nombre: String, fechaVencimiento: String): Producto?

    @Query("SELECT * FROM Productos")
    suspend fun obtenerTodosLosProductos(): List<Producto>

    @Query("DELETE FROM Productos WHERE id = :id")
    suspend fun eliminarProductoPorId(id: Int)
}