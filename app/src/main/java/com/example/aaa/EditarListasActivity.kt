package com.example.aaa.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.aaa.R
import com.example.aaa.adapters.RecyclerListaEjemploAdapter

import com.example.aaa.dataclasses.Producto
import com.example.aaa.databinding.ActivityEditarListasBinding

class EditarListasActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEditarListasBinding
    private lateinit var recyclerListaEjemploAdapter: RecyclerListaEjemploAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditarListasBinding.inflate(layoutInflater)
        setContentView(binding.root)

        recyclerListaEjemploAdapter = RecyclerListaEjemploAdapter()
        binding.recyclerViewProductos.layoutManager = LinearLayoutManager(this)
        binding.recyclerViewProductos.adapter = recyclerListaEjemploAdapter

        loadProductos()
    }

    private fun loadProductos() {
        val productos = listOf(
            Producto(id = 0, nombre = "Producto 1", fechaVencimiento = "12/03", estado = "Vencido", lista = "Lista 1", cantidad = 5),
            Producto(id = 0, nombre = "Producto 2", fechaVencimiento = "15/01/2025", estado = "Vigente", lista = "Lista 2", cantidad = 3),
            Producto(id = 0, nombre = "Producto 3", fechaVencimiento = "20/02/2025", estado = "Vencido", lista = "Lista 3", cantidad = 8)
        )

        recyclerListaEjemploAdapter.addDataToList(productos)
    }
}