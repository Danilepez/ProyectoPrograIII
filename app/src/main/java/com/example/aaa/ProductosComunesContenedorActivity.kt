package com.example.aaa

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.aaa.adapters.Recycler.App.RecyclerProductosComunesContenedorAdapter
import com.example.aaa.databinding.ActivityProductosComunesContenedorBinding
import com.example.aaa.singletons.ProductosComunes
import com.example.aaa.singletons.ProductosContenedor

class ProductosComunesContenedorActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProductosComunesContenedorBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductosComunesContenedorBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()

        binding.btnAgregar.setOnClickListener {
            val intent = Intent(this, ContenedorActivity::class.java)
            startActivity(intent)
        }

    }
    private fun initRecyclerView() {
        val manager = GridLayoutManager(this, 2)
        val decoration = DividerItemDecoration(this, manager.orientation)
        binding.recyclerViewProductosComunes.layoutManager = GridLayoutManager(this, 2)
        binding.recyclerViewProductosComunes.adapter = RecyclerProductosComunesContenedorAdapter(ProductosComunes.productosComunesList)
        binding.recyclerViewProductosComunes.addItemDecoration(decoration)

    }
}

