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

        initRecyclerView()

        cargarListaDesdeIntent()

        binding.btnModificar.setOnClickListener {
            val intent = intent
            intent.setClass(this, EditarListasActivity::class.java)
            startActivity(intent)
        }
        binding.btnCheck.setOnClickListener {
        }
    }

    private fun initRecyclerView() {
        recyclerListaEjemploAdapter = RecyclerListaEjemploAdapter(mutableListOf())
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

    private fun cargarListaDesdeIntent() {
        val listaNombre = intent.getStringExtra("listaNombre")  // Obtener el nombre de la lista desde el Intent
        lista = Listas.getListaByName(listaNombre ?: "") ?: Lista("", mutableListOf())  // Buscar la lista en el Singleton

        if (lista.listaProductos.isNotEmpty()) {
            setupRecyclerView(lista.listaProductos)
        } else {
            Toast.makeText(this, "Lista no encontrada o está vacía", Toast.LENGTH_SHORT).show()
        }
    }
}