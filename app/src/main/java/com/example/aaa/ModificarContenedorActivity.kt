package com.example.aaa

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.aaa.adapters.Recycler.App.RecyclerModificarContenedorAdapter
import com.example.aaa.databinding.ActivityModificarContenedorBinding
import com.example.aaa.singletons.ProductosContenedor

class ModificarContenedorActivity : AppCompatActivity() {

    private lateinit var binding: ActivityModificarContenedorBinding
    private lateinit var recyclerModificarContenedorAdapter: RecyclerModificarContenedorAdapter // No usamos `by lazy` ahora


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityModificarContenedorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        recyclerModificarContenedorAdapter = RecyclerModificarContenedorAdapter(ProductosContenedor.productosContenedor)

        initRecyclerView()


        binding.btnPlus.setOnClickListener {
            val intent = Intent(this, ProductosComunesContenedorActivity::class.java)
            startActivity(intent)
        }

        binding.btnMinus.setOnClickListener {
            val intent = Intent(this, EliminarProductosContenedorActivity::class.java)
            startActivity(intent)
        }
    }
    private fun initRecyclerView() {
        val manager = LinearLayoutManager(this)

        val decoration = DividerItemDecoration(this, manager.orientation)

        binding.rvModificar.layoutManager = manager
        binding.rvModificar.adapter = recyclerModificarContenedorAdapter
        binding.rvModificar.addItemDecoration(decoration)
    }
}