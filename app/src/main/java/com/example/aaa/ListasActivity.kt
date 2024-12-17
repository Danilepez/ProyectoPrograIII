package com.example.aaa

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.aaa.adapters.RecyclerListasAdapter
import com.example.aaa.dataclasses.Lista
import com.example.aaa.databinding.ActivityListasBinding
import com.example.aaa.singletons.Listas

class ListasActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListasBinding
    private lateinit var recyclerListasAdapter: RecyclerListasAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListasBinding.inflate(layoutInflater)
        setContentView(binding.root)

        recyclerListasAdapter = RecyclerListasAdapter(Listas.listas) { lista ->
            onListaClick(lista)
        }

        initRecyclerView()

        binding.btnPlus.setOnClickListener {
            // Código para añadir listas (si lo necesitas)
        }

        binding.btnMinus.setOnClickListener {
            // Código para eliminar listas (si lo necesitas)
        }
    }

    private fun initRecyclerView() {
        val manager = LinearLayoutManager(this)
        val decoration = DividerItemDecoration(this, manager.orientation)
        binding.recyclerViewLists.layoutManager = manager
        binding.recyclerViewLists.adapter = recyclerListasAdapter
        binding.recyclerViewLists.addItemDecoration(decoration)
    }

    private fun onListaClick(lista: Lista) {
        // Navegar a ListaEjemploActivity
        val intent = Intent(this, ListaEjemploActivity::class.java)
        intent.putExtra("listaNombre", lista.nombre) // Pasar el nombre de la lista
        intent.putExtra("listaProductos", ArrayList(lista.listaProductos)) // Pasar la lista de productos
        startActivity(intent)
    }
}
