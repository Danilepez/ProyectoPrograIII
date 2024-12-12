package com.example.aaa

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.aaa.adapters.Recycler.Contenedor.RecyclerContenedorAdapter
import com.example.aaa.dataclasses.Producto
import com.example.aaa.storage.SharedPreferencesUtil

class ContenedorActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: RecyclerContenedorAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contenedor)

        recyclerView = findViewById(R.id.rvProducts)
        adapter = RecyclerContenedorAdapter()
        recyclerView.adapter = adapter

        // Cargar productos (si existen)
        cargarProductos()

        // Agregar un producto de ejemplo
        val nuevoProducto = Producto("Nuevo Producto", "2025-12-01", "Disponible", "Lista1",10)
        adapter.addProduct(nuevoProducto)
    }

    private fun cargarProductos() {
        // Cargar productos al iniciar la actividad desde SharedPreferences
        val productos = SharedPreferencesUtil.loadFromSharedPreferences(this)
        adapter.addDataToList(productos)
    }
}