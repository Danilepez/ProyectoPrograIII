package com.example.aaa

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.aaa.adapters.RecyclerEditarListasAdapter
import com.example.aaa.databinding.ActivityEditarListasBinding
import com.example.aaa.singletons.Listas

class EditarListasActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEditarListasBinding
    private lateinit var recyclerEditarListasAdapter: RecyclerEditarListasAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditarListasBinding.inflate(layoutInflater)
        setContentView(binding.root)

        recyclerEditarListasAdapter = RecyclerEditarListasAdapter(Listas.listas[0].listaProductos)

        initRecyclerView()

        binding.btnPlus.setOnClickListener {
            val intent = Intent(this, AgregarProductoListaActivity::class.java)
            startActivity(intent)
        }

        binding.btnMinus.setOnClickListener {
            val intent = Intent(this, EliminarProductoListaActivity::class.java)
            startActivity(intent)
        }
    }

    private fun initRecyclerView() {
        val manager = LinearLayoutManager(this)
        val decoration = DividerItemDecoration(this, manager.orientation)

        binding.rvModificar.layoutManager = manager
        binding.rvModificar.adapter = recyclerEditarListasAdapter
        binding.rvModificar.addItemDecoration(decoration)
    }
}
