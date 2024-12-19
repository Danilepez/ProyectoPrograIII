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
        initRecyclerView()

        binding.recyclerViewLists.apply {
            adapter = recyclerListasAdapter
            layoutManager = LinearLayoutManager(this@ListasActivity)
        }

        binding.titulo.text = "Listas"

        binding.btnPlus.setOnClickListener {
        }

        binding.btnMinus.setOnClickListener {

        }
    }

    private fun initRecyclerView() {
        recyclerListasAdapter = RecyclerListasAdapter(Listas.listas)
    }
}