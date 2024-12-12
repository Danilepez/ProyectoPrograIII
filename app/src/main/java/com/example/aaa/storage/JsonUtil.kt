package com.example.aaa.storage

import android.content.Context
import com.example.aaa.dataclasses.Producto
import com.google.gson.Gson

object JsonUtil {

    private const val FILE_NAME = "productos.json"

    // Guardar la lista de productos como JSON en un archivo
    fun saveToJson(context: Context, listaProductos: List<Producto>) {
        val gson = Gson()
        val jsonString = gson.toJson(listaProductos)

        val file = context.openFileOutput(FILE_NAME, Context.MODE_PRIVATE)
        file.write(jsonString.toByteArray())
        file.close()
    }

    // Cargar la lista de productos desde JSON
    fun loadFromJson(context: Context): List<Producto> {
        val file = context.openFileInput(FILE_NAME)

        if (file.available() == 0) {
            return emptyList()  // Si el archivo está vacío, retorna una lista vacía
        }

        val jsonString = file.bufferedReader().use { it.readText() }
        val gson = Gson()
        return gson.fromJson(jsonString, Array<Producto>::class.java).toList()
    }
}