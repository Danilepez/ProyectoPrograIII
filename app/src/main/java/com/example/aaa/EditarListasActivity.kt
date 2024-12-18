package com.example.aaa

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.aaa.R
import com.example.aaa.adapters.RecyclerListaEjemploAdapter
import com.example.aaa.dataclasses.Lista
import com.example.aaa.dataclasses.Producto
import com.example.aaa.singletons.Listas

class EditarListasActivity : AppCompatActivity() {

    private lateinit var lista: Lista

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_editar_listas)

        val listaNombre = intent.getStringExtra("listaNombre")  // Obtener el nombre de la lista desde el Intent
        lista = Listas.getListaByName(listaNombre ?: "") ?: Lista("", mutableListOf())  // Buscar la lista en el Singleton

        if (lista.listaProductos.isNotEmpty()) {
            // Cargar los productos de la lista
            setupRecyclerView(lista.listaProductos)
        } else {
            // Manejo en caso de que no se encuentre la lista o la lista esté vacía
            Toast.makeText(this, "Lista no encontrada o está vacía", Toast.LENGTH_SHORT).show()
        }
    }

    private fun setupRecyclerView(productos: List<Producto>) {
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewProductos)
        val adapter = RecyclerListaEjemploAdapter(productos)
        recyclerView.adapter = adapter
    }
}
