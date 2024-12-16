package com.example.aaa.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.aaa.adapters.Recycler.App.ProductoAdapter
import com.example.aaa.databinding.ActivityListaEjemploBinding
import com.example.aaa.singletons.ProductosManager
import com.example.aaa.database.AppDatabase
import kotlinx.coroutines.launch

class ListaEjemploActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListaEjemploBinding
    private lateinit var productoAdapter: ProductoAdapter
    private lateinit var db: AppDatabase // Instancia de la base de datos

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListaEjemploBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Inicializar la base de datos
        db = AppDatabase.getInstance(this)

        productoAdapter = ProductoAdapter()
        binding.recyclerViewProductos.apply {
            layoutManager = LinearLayoutManager(this@ListaEjemploActivity)
            adapter = productoAdapter
        }

        loadProductos()

        binding.btnEnviarProductos.setOnClickListener {
            val productosSeleccionados = productoAdapter.getSelectedItems()
            val intent = Intent(this, ContenedorActivity::class.java)
            intent.putExtra(ProductosManager.CLAVE_PRODUCTOS_SELECCIONADOS, ArrayList(productosSeleccionados))
            startActivity(intent)
        }
    }

    private fun loadProductos() {
        lifecycleScope.launch {
            val productos = db.productoDao().obtenerTodosProductos() // Obtener todos los productos de la base de datos
            productoAdapter.setData(productos)
        }
    }
}
