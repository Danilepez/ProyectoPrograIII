package com.example.aaa

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.aaa.adapters.Recycler.Contenedor.RecyclerContenedorAdapter
import com.example.aaa.databinding.ActivityContenedorBinding
import com.example.aaa.dataclasses.Producto
import com.example.aaa.storage.JsonUtil
import com.example.aaa.storage.SharedPreferencesUtil

class ContenedorActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: RecyclerContenedorAdapter
    private lateinit var binding: ActivityContenedorBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContenedorBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_contenedor)

        recyclerView = findViewById(R.id.rvProducts)
        adapter = RecyclerContenedorAdapter()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Cargar productos (si existen)
        cargarProductos()

        // Agregar un producto de ejemplo
        val nuevoProducto = Producto("Nuevo Producto", "2025-12-01", "Disponible", "Lista1",10)
        adapter.addProduct(nuevoProducto)
    }

    // Método para cargar productos desde el archivo JSON
    private fun cargarProductos() {
        val productos = JsonUtil.loadFromJson(this)
        adapter.addDataToList(productos)
    }
}