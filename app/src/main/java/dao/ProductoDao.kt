package com.example.aaa.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import androidx.room.OnConflictStrategy
import com.example.aaa.dataclasses.Producto // Asegúrate de importar correctamente la clase Producto

@Dao
interface ProductoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProducto(producto: Producto)

    @Query("SELECT * FROM productos")
    suspend fun getAllProductos(): List<Producto>

    @Delete
    suspend fun deleteProducto(producto: Producto)

    @Update
    suspend fun updateProducto(producto: Producto)
}

