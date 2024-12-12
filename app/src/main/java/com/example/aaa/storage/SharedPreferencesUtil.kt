package com.example.aaa.storage

import android.content.Context
import android.content.SharedPreferences
import com.example.aaa.dataclasses.Producto
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.File
import java.lang.reflect.Type

object SharedPreferencesUtil {
    private const val PREF_NAME = "productos_pref"
    private const val KEY_PRODUCTOS = "productos"

    // Guardar la lista de productos como JSON en SharedPreferences
    fun saveToSharedPreferences(context: Context, listaProductos: List<Producto>) {
        val sharedPreferences: SharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        val gson = Gson()
        val jsonString = gson.toJson(listaProductos)
        sharedPreferences.edit().putString(KEY_PRODUCTOS, jsonString).apply()
    }

    // Cargar la lista de productos desde SharedPreferences
    fun loadFromSharedPreferences(context: Context): List<Producto> {
        val sharedPreferences: SharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        val jsonString = sharedPreferences.getString(KEY_PRODUCTOS, null)

        if (jsonString == null) {
            return emptyList()  // Si no hay productos guardados, retorna una lista vacía
        }

        val gson = Gson()
        val type = object : TypeToken<List<Producto>>() {}.type
        return gson.fromJson(jsonString, type)
    }
}