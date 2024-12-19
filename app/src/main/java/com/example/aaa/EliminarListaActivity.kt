package com.example.aaa

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.aaa.adapters.Recycler.App.RecyclerEliminarListaAdapter
import com.example.aaa.databinding.ActivityEliminarListaBinding
import com.example.aaa.dataclasses.Lista
import com.example.aaa.singletons.Listas

class EliminarListaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEliminarListaBinding
    private lateinit var adapter: RecyclerEliminarListaAdapter
    private val listasSeleccionadas = mutableListOf<Lista>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEliminarListaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initRecyclerView()


        binding.btnEliminar.isEnabled = false
        binding.btnEliminar.setOnClickListener {
            eliminarListasSeleccionadas()
        }
    }

    private fun initRecyclerView() {
        // Asumiendo que Listas.listas contiene todas las listas
        val listas = Listas.listas

        adapter = RecyclerEliminarListaAdapter(listas) { lista, isChecked ->
            if (isChecked) {
                listasSeleccionadas.add(lista)
            } else {
                listasSeleccionadas.remove(lista)
            }

            // Habilitar el botón solo si hay listas seleccionadas
            binding.btnEliminar.isEnabled = listasSeleccionadas.isNotEmpty()
        }

        binding.recyclerViewLists.adapter = adapter
        val manager = LinearLayoutManager(this)
        binding.recyclerViewLists.layoutManager = manager
    }

    private fun eliminarListasSeleccionadas() {
        // Eliminar las listas seleccionadas
        if (listasSeleccionadas.isNotEmpty()) {
            Listas.listas.removeAll { lista ->
                listasSeleccionadas.contains(lista)
            }

            listasSeleccionadas.clear()

            Toast.makeText(this, "Listas eliminadas", Toast.LENGTH_SHORT).show()
            finish() // Cierra la actividad y regresa a la actividad anterior
        } else {
            Toast.makeText(this, "No hay listas seleccionadas", Toast.LENGTH_SHORT).show()
        }
    }
}