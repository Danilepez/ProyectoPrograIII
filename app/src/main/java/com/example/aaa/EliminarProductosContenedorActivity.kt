package com.example.aaa

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.aaa.adapters.Recycler.App.RecyclerEliminarContenedorAdapter
import com.example.aaa.databinding.ActivityEliminarProductosContenedorBinding
import com.example.aaa.singletons.ProductosContenedor
import com.example.aaa.singletons.ProductosEliminarContenedor
import android.widget.Toast

class EliminarProductosContenedorActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEliminarProductosContenedorBinding
    private lateinit var adapter: RecyclerEliminarContenedorAdapter
    private val productos = ProductosContenedor.productosContenedor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEliminarProductosContenedorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initRecyclerView()

        binding.btnEliminar.setOnClickListener {
            eliminarProductosSeleccionados()
        }
    }

    private fun initRecyclerView() {
        // Inicializamos el adaptador con el callback de selección
        adapter = RecyclerEliminarContenedorAdapter(productos) { producto, isChecked ->
            if (isChecked) {
                // Si está seleccionado, agregar al singleton de productos a eliminar
                ProductosEliminarContenedor.productosEliminarContenedor.add(producto)
            } else {
                // Si está deseleccionado, eliminar del singleton
                ProductosEliminarContenedor.productosEliminarContenedor.remove(producto)
            }

            // Habilitar el botón de eliminar solo si hay productos seleccionados
            binding.btnEliminar.isEnabled = ProductosEliminarContenedor.productosEliminarContenedor.isNotEmpty()
        }
        binding.recyclerViewEliminarProductosContenedor.layoutManager = LinearLayoutManager(this)
        binding.recyclerViewEliminarProductosContenedor.adapter = adapter
    }

    private fun eliminarProductosSeleccionados() {
        if (ProductosEliminarContenedor.productosEliminarContenedor.isNotEmpty()) {
            ProductosContenedor.productosContenedor.removeAll { producto ->
                ProductosEliminarContenedor.productosEliminarContenedor.contains(producto)
            }

            ProductosEliminarContenedor.productosEliminarContenedor.clear()

            Toast.makeText(this, "Productos eliminados", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, ContenedorActivity::class.java)
            startActivity(intent)
        } else {
            Toast.makeText(this, "No hay productos seleccionados", Toast.LENGTH_SHORT).show()
        }
    }
}