package com.example.aaa.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.aaa.R
import com.example.aaa.adapters.RecyclerListasAdapter
import com.example.aaa.dataclasses.Lista
import com.example.aaa.databinding.ActivityListasBinding


class ListasActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListasBinding
    private lateinit var listasAdapter: RecyclerListasAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListasBinding.inflate(layoutInflater)
        setContentView(binding.root)

        listasAdapter = RecyclerListasAdapter(mutableListOf()) { lista ->
            onListaClick(lista)
        }
        binding.recyclerViewLists.layoutManager = LinearLayoutManager(this)
        binding.recyclerViewLists.adapter = listasAdapter

        loadListas()
    }

    private fun loadListas() {
        val listas = listOf(
            Lista(nombre = "Supermercado"),
            Lista(nombre = "Carnicería"),
            Lista(nombre = "Frutería")
        )
        listasAdapter.updateList(listas)
    }

    private fun onListaClick(lista: Lista) {
    }
}
