package com.example.aaa

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.aaa.adapters.Recycler.App.RecyclerListaEjemploAdapter
import com.example.aaa.databinding.ActivityEditarListasBinding

class EditarListasActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEditarListasBinding
    private lateinit var recyclerListaEjemploAdapter: RecyclerListaEjemploAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditarListasBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //recyclerListaEjemploAdapter = RecyclerListaEjemploAdapter()
        binding.recyclerViewProductos.layoutManager = LinearLayoutManager(this)
        binding.recyclerViewProductos.adapter = recyclerListaEjemploAdapter
    }
}
