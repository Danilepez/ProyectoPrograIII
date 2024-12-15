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
            Producto("Producto 1", "12/12/2024", "Vencido", "Lista 1", 5),
            Producto("Producto 2", "15/01/2025", "Vigente", "Lista 2", 3),
            Producto("Producto 3", "20/02/2025", "Vencido", "Lista 3", 8)
        )

        recyclerListaEjemploAdapter.addDataToList(productos)
    }
}
