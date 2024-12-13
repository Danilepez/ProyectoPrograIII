package com.example.aaa

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.aaa.adapters.Recycler.Contenedor.RecyclerContenedorAdapter
import com.example.aaa.databinding.ActivityContenedorBinding
import com.example.aaa.dataclasses.Producto

class ContenedorActivity : AppCompatActivity() {

    private lateinit var binding: ActivityContenedorBinding
    private lateinit var recyclerContenedorAdapter: RecyclerContenedorAdapter
    private lateinit var productList: List<Producto>
    private var showDetails: Boolean = false // Estado global de visibilidad

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContenedorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Inicializar RecyclerView
        recyclerContenedorAdapter = RecyclerContenedorAdapter()
        binding.rvProducts.apply {
            layoutManager = LinearLayoutManager(this@ContenedorActivity)
            adapter = recyclerContenedorAdapter
        }

        // Crear una lista de productos
        productList = listOf(
            Producto("Producto 1", "Lista A", "2024-12-01","Disponible", 10),
            Producto("Producto 2", "Lista B", "2025-01-15","Agotado", 20),
            Producto("Producto 3", "Lista C", "2024-11-20", "Disponible", 5)
        )

        // Agregar los productos al adaptador
        recyclerContenedorAdapter.addDataToList(productList)

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
    }
}