package com.example.aaa

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.aaa.adapters.Recycler.App.RecyclerContenedorAdapter
import com.example.aaa.adapters.Recycler.App.RecyclerProductosComunesContenedorAdapter
import com.example.aaa.databinding.ActivityContenedorBinding
import com.example.aaa.dataclasses.Producto
import com.example.aaa.singletons.ProductosComunes
import com.example.aaa.singletons.ProductosContenedor

class ContenedorActivity : AppCompatActivity() {

    private lateinit var binding: ActivityContenedorBinding
    //private val recyclerContenedorAdapter by lazy { RecyclerContenedorAdapter( ) }
    private var showDetails: Boolean = false // Estado global de visibilidad

    companion object {
        const val CLAVE_LISTA_PRODUCTOS = "LISTA_PRODUCTOS"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContenedorBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()


        // Configurar botones
        binding.btnCompactView.setOnClickListener {
            if (showDetails) {
                showDetails = false
                //recyclerContenedorAdapter.toggleDetails(false)
            }
        }

        binding.btnDetailedView.setOnClickListener {
            if (!showDetails) {
                showDetails = true
                //recyclerContenedorAdapter.toggleDetails(true)
            }
        }

        binding.btnModify.setOnClickListener {
            // Redirige a la pantalla de "Modificar contenedor" (Pantalla 8)
            val intent = Intent(this, ModificarContenedorActivity::class.java)
            startActivity(intent)
        }
    }
    private fun initRecyclerView() {
        val manager = GridLayoutManager(this, 2)
        val decoration = DividerItemDecoration(this, manager.orientation)
        binding.rvProducts.layoutManager = LinearLayoutManager(this)
        //binding.rvProducts.adapter = recyclerContenedorAdapter
        binding.rvProducts.addItemDecoration(decoration)
    }
}