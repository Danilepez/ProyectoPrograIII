package com.example.aaa

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.aaa.adapters.Recycler.App.RecyclerContenedorAdapter
import com.example.aaa.databinding.ActivityContenedorBinding
import com.example.aaa.singletons.ProductosContenedor

class ContenedorActivity : AppCompatActivity() {

    private lateinit var binding: ActivityContenedorBinding
    private lateinit var recyclerContenedorAdapter : RecyclerContenedorAdapter
    private var showDetails: Boolean = false // Estado global de visibilidad


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContenedorBinding.inflate(layoutInflater)
        setContentView(binding.root)
        recyclerContenedorAdapter = RecyclerContenedorAdapter(ProductosContenedor.productosContenedor)
        initRecyclerView()


        // Configurar botones
        binding.btnCompactView.setOnClickListener {
            if (showDetails) {
                showDetails = false
                recyclerContenedorAdapter.toggleDetails(false)
            }
        }

        binding.btnDetailedView.setOnClickListener {
            if (!showDetails) {
                showDetails = true
                recyclerContenedorAdapter.toggleDetails(true)
            }
        }

        binding.btnModify.setOnClickListener {
            val intent = Intent(this, ModificarContenedorActivity::class.java)
            startActivity(intent)
        }
    }
    private fun initRecyclerView() {
        val manager = GridLayoutManager(this, 2)
        val decoration = DividerItemDecoration(this, manager.orientation)
        binding.rvProducts.layoutManager = LinearLayoutManager(this)
        binding.rvProducts.adapter = recyclerContenedorAdapter
        binding.rvProducts.addItemDecoration(decoration)
    }
}