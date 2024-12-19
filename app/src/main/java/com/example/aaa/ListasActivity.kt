package com.example.aaa

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.aaa.adapters.RecyclerListasAdapter
import com.example.aaa.databinding.ActivityListasBinding
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
            // Lógica para agregar una nueva lista
            //agregarLista()
        }

        binding.btnMinus.setOnClickListener {
            // Lógica para eliminar una lista
            //eliminarLista()
        }
    }

    private fun initRecyclerView() {
        recyclerListasAdapter = RecyclerListasAdapter(Listas.listas)
    }
}
