package com.example.aaa

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.aaa.adapters.Recycler.App.ListaViewHolder.Companion.NOMBRE_LISTA
import com.example.aaa.adapters.Recycler.App.ListaViewHolder.Companion.ID_LISTA
import com.example.aaa.adapters.Recycler.App.RecyclerCombinar2Adapter
import com.example.aaa.databinding.ActivityCombinar2Binding
import com.example.aaa.singletons.Listas

class CombinarActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityCombinar2Binding
    private lateinit var adapter: RecyclerCombinar2Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCombinar2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val idListaActual = intent.getIntExtra(ID_LISTA, 0)
        val nombreListaActual = intent.getStringExtra(NOMBRE_LISTA)

        val listasFiltradas = Listas.listas.filter { it.id != idListaActual }

        adapter = RecyclerCombinar2Adapter(listasFiltradas, ) { id, nombre ->
            val intent = Intent(this, CombinarActivity3::class.java)
            intent.putExtra(ID_LISTA, id)
            intent.putExtra(NOMBRE_LISTA, nombre)
            startActivity(intent)
        }

        binding.recyclerViewCombinar.adapter = adapter
        binding.recyclerViewCombinar.layoutManager = LinearLayoutManager(this)

        // Establecer el título
        binding.titulo.text = "Selecciona una lista para combinar con $nombreListaActual"
    }
}
