package com.example.aaa

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
        }

        binding.btnMinus.setOnClickListener {
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