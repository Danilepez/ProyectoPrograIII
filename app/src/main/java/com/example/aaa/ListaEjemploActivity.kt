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
            Producto(id = 0, nombre = "Producto 1", fechaVencimiento = "12/03", estado = "Vencido", lista = "Lista 1", cantidad = 5),
            Producto(id = 0, nombre = "Producto 2", fechaVencimiento = "15/01/2025", estado = "Vigente", lista = "Lista 2", cantidad = 3),
            Producto(id = 0, nombre = "Producto 3", fechaVencimiento = "20/02/2025", estado = "Vencido", lista = "Lista 3", cantidad = 8)
        )

        productoAdapter = ProductoAdapter()
        binding.recyclerViewProductos.apply {
            layoutManager = LinearLayoutManager(this@ListaEjemploActivity)
            adapter = productoAdapter
        }

        productoAdapter.setData(productosList)
    }
}
