package com.example.aaa

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.aaa.adapters.RecyclerListaEjemploAdapter
import com.example.aaa.databinding.ActivityListaEjemploBinding
import com.example.aaa.dataclasses.Lista
import com.example.aaa.dataclasses.Producto
import com.example.aaa.singletons.Listas

class ListaEjemploActivity : AppCompatActivity() {

    private lateinit var lista: Lista
    private lateinit var recyclerListaEjemploAdapter: RecyclerListaEjemploAdapter
    private lateinit var binding: ActivityListaEjemploBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListaEjemploBinding.inflate(layoutInflater)
        setContentView(binding.root)

        recyclerListaEjemploAdapter = RecyclerListaEjemploAdapter(mutableListOf())

        initRecyclerView()


        val listaNombre = intent.getStringExtra("listaNombre")  // Obtener el nombre de la lista desde el Intent
        lista = Listas.getListaByName(listaNombre ?: "") ?: Lista("", mutableListOf())  // Buscar la lista en el Singleton
        if (lista.listaProductos.isNotEmpty()) {
            // Cargar los productos de la lista
            setupRecyclerView(lista.listaProductos)
        } else {
            // Manejo en caso de que no se encuentre la lista o la lista esté vacía
            Toast.makeText(this, "Lista no #$&$#encontrada o está vacía%#%#%##%#", Toast.LENGTH_SHORT).show()
        }
    }

    private fun initRecyclerView() {
        val manager = LinearLayoutManager(this)
        val decoration = DividerItemDecoration(this, manager.orientation)
        binding.recyclerViewProductos.layoutManager = manager
            binding.recyclerViewProductos.adapter = recyclerListaEjemploAdapter
        binding.recyclerViewProductos.addItemDecoration(decoration)

    }

    private fun setupRecyclerView(productos: List<Producto>) {
        val adapter = RecyclerListaEjemploAdapter(productos)
        binding.recyclerViewProductos.adapter = adapter
    }
}