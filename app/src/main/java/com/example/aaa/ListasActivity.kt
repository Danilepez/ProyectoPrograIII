package com.example.aaa

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.aaa.adapters.RecyclerListasAdapter
import com.example.aaa.databinding.ActivityListasBinding
import com.example.aaa.dataclasses.Lista
import com.example.aaa.singletons.Listas

class ListasActivity : AppCompatActivity() {



    private lateinit var binding: ActivityListasBinding
    private lateinit var recyclerListasAdapter: RecyclerListasAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListasBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()

        binding.recyclerViewLists.apply {
            adapter = recyclerListasAdapter
            layoutManager = LinearLayoutManager(this@ListasActivity)
        }

        binding.titulo.text = "Listas"

        binding.btnPlus.setOnClickListener {
            agregarLista()
        }

        binding.btnMinus.setOnClickListener {
            val intent = Intent(this, EliminarListaActivity::class.java)
            startActivity(intent)
        }

    }

    private fun initRecyclerView() {
        recyclerListasAdapter = RecyclerListasAdapter(Listas.listas)
    }
    private fun agregarLista() {
        // Mostrar un cuadro de texto para ingresar el nombre de la nueva lista
        val ultimoId = Listas.listas.lastOrNull()?.id ?: 0
        val nuevoId = ultimoId + 1
        val input = EditText(this)
        val dialog = AlertDialog.Builder(this)
            .setTitle("Ingrese el nombre de la nueva lista")
            .setView(input)
            .setPositiveButton("Agregar") { _, _ ->
                val listaNombre = input.text.toString()
                if (listaNombre.isNotEmpty()) {
                    // Crear una nueva lista con el nombre proporcionado
                    val nuevaLista = Lista(nuevoId ,nombre = listaNombre, listaProductos = mutableListOf())
                    // Agregar la nueva lista a la lista de listas
                    Listas.listas.add(nuevaLista)
                    // Notificar al adaptador para que actualice el RecyclerView
                    recyclerListasAdapter.notifyItemInserted(Listas.listas.size - 1)
                } else {
                    Toast.makeText(this, "Por favor, ingrese un nombre válido", Toast.LENGTH_SHORT).show()
                }
            }
            .setNegativeButton("Cancelar", null)
            .create()

        dialog.show()
    }
}
