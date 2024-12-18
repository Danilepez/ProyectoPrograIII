package com.example.aaa

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.aaa.adapters.RecyclerListasAdapter
import com.example.aaa.databinding.ActivityListasBinding
import com.example.aaa.singletons.Listas
import com.example.aaa.dataclasses.Lista

class ListasActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListasBinding
    private lateinit var recyclerListasAdapter: RecyclerListasAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListasBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Configuración del RecyclerView con su adaptador
        recyclerListasAdapter = RecyclerListasAdapter(Listas.listas) { lista ->
            onListaClick(lista)
        }

        binding.recyclerViewLists.apply {
            adapter = recyclerListasAdapter
            layoutManager = LinearLayoutManager(this@ListasActivity)
        }

        // Configurar los botones de agregar y eliminar
        binding.btnPlus.setOnClickListener {
            // Lógica para agregar una nueva lista
            //agregarLista()
        }

        binding.btnMinus.setOnClickListener {
            // Lógica para eliminar una lista
            //eliminarLista()
        }
    }

    // Acción al hacer clic en un elemento de la lista
    private fun onListaClick(lista: Lista) {
        val intent = Intent(this, ListaEjemploActivity::class.java)
        intent.putExtra("listaNombre", lista.nombre)
        startActivity(intent)
    }
}
