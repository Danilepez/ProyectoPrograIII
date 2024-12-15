package com.example.aaa.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.aaa.adapters.Recycler.App.ProductoAdapter
import com.example.aaa.dataclasses.Producto
import com.example.aaa.databinding.ActivityListaEjemploBinding

class ListaEjemploActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListaEjemploBinding
    private lateinit var productoAdapter: ProductoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListaEjemploBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val productosList = listOf(
            Producto("Producto 1", "2024-12-31", "Disponible", "Lista 1", 5),
            Producto("Producto 2", "2025-01-15", "Vencido", "Lista 2", 3)
        )

        productoAdapter = ProductoAdapter()
        binding.recyclerViewProductos.apply {
            layoutManager = LinearLayoutManager(this@ListaEjemploActivity)
            adapter = productoAdapter
        }

        productoAdapter.setData(productosList)
    }
}
