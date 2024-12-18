package com.example.aaa

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.aaa.adapters.Recycler.App.RecyclerListaEjemploAdapter
import com.example.aaa.adapters.RecyclerListasAdapter
import com.example.aaa.dataclasses.Lista
import com.example.aaa.databinding.ActivityListasBinding
import com.example.aaa.room.DatabaseProvider
import com.example.aaa.singletons.Listas
import kotlinx.coroutines.launch

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

        // Obtener las listas con sus productos en un hilo en segundo plano
        lifecycleScope.launch {
            val listaConProductos = DatabaseProvider.getDatabase(binding.btnPlus.context).listaDao().getAllListas()
            // Ahora tenemos una lista de ListaConProductos, la pasamos al adaptador
            recyclerListasAdapter = RecyclerListasAdapter(Listas.listas) { lista ->
                onListaClick(lista)
            }
        }


        initRecyclerView()


        binding.btnPlus.setOnClickListener {
            // Lógica para agregar una nueva lista
        }

        binding.btnMinus.setOnClickListener {
            // Lógica para eliminar una lista
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

    }
}