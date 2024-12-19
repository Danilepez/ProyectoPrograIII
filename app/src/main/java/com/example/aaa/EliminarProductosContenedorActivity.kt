package com.example.aaa

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.aaa.adapters.Recycler.App.RecyclerEliminarContenedorAdapter
import com.example.aaa.databinding.ActivityEliminarProductosContenedorBinding
import com.example.aaa.singletons.ProductosContenedor
import com.example.aaa.dataclasses.Producto
import android.widget.Toast

class EliminarProductosContenedorActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEliminarProductosContenedorBinding
    private lateinit var adapter: RecyclerEliminarContenedorAdapter
    private val productos = ProductosContenedor.productosContenedor
    private val productosSeleccionados = mutableListOf<Producto>() // Variable local para almacenar los productos seleccionados

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEliminarProductosContenedorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initRecyclerView()

        binding.btnEliminar.isEnabled = false
        binding.btnEliminar.setOnClickListener {
            // Llamamos a la función que eliminará los productos seleccionados
            eliminarProductosSeleccionados()
        }
    }

    private fun initRecyclerView() {
        // Inicializamos el adaptador con el callback de selección
        adapter = RecyclerEliminarContenedorAdapter(productos) { producto, isChecked ->
            if (isChecked) {
                // Si está seleccionado, agregarlo a la lista local de productos seleccionados
                productosSeleccionados.add(producto)
            } else {
                // Si está deseleccionado, eliminarlo de la lista local
                productosSeleccionados.remove(producto)
            }

            // Habilitar el botón de eliminar solo si hay productos seleccionados
            binding.btnEliminar.isEnabled = productosSeleccionados.isNotEmpty()
        }
        binding.recyclerViewEliminarProductosContenedor.layoutManager = LinearLayoutManager(this)
        binding.recyclerViewEliminarProductosContenedor.adapter = adapter
    }

    private fun eliminarProductosSeleccionados() {
        if (productosSeleccionados.isNotEmpty()) {
            productos.removeAll { producto ->
                productosSeleccionados.contains(producto)
            }

            productosSeleccionados.clear()

            Toast.makeText(this, "Productos eliminados", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, ContenedorActivity::class.java)
            startActivity(intent)
        } else {
            Toast.makeText(this, "No hay productos seleccionados", Toast.LENGTH_SHORT).show()
        }
    }
}
