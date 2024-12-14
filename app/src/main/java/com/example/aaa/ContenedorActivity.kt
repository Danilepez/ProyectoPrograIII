package com.example.aaa

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.aaa.adapters.Recycler.App.RecyclerContenedorAdapter
import com.example.aaa.databinding.ActivityContenedorBinding
import com.example.aaa.dataclasses.Producto
import com.example.aaa.singletons.ProductosManager

class ContenedorActivity : AppCompatActivity() {

    private lateinit var binding: ActivityContenedorBinding
    private val recyclerContenedorAdapter by lazy {RecyclerContenedorAdapter()}
    private var showDetails: Boolean = false // Estado global de visibilidad

    // Lista que almacenará los productos recibidos
    private val productosEnContenedor = mutableListOf<Producto>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContenedorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Verificar si la lista de productos en contenedor tiene datos
        Log.d("ContenedorActivity", "Productos en contenedor: ${ProductosManager.productosEnContenedor.size}")


        binding.rvProducts.apply {
            layoutManager = LinearLayoutManager(this@ContenedorActivity)
            adapter = recyclerContenedorAdapter
        }

        // Recibir los productos seleccionados desde la actividad anterior
        // Recuperar los productos seleccionados desde el putExtra
        val productosRecibidos = intent.getSerializableExtra(ProductosManager.CLAVE_PRODUCTOS_SELECCIONADOS) as? ArrayList<Producto>

        // Verificar y acumular los productos
        productosRecibidos?.forEach { productoSeleccionado ->
            // Verificar si el producto ya existe en el contenedor
            val productoExistente = productosEnContenedor.find { it.nombre == productoSeleccionado.nombre }

            if (productoExistente != null) {
                // Si ya existe, incrementa la cantidad
                productoExistente.cantidad += productoSeleccionado.cantidad
            } else {
                // Si no existe, agregarlo como nuevo producto
                productosEnContenedor.add(productoSeleccionado)
            }
        }

        // Actualizar el RecyclerView con los productos acumulados
        recyclerContenedorAdapter.addDataToList(productosEnContenedor)
        // Verificar acumulación antes de pasar al adaptador
        Log.d("ContenedorActivity", "Productos enviados al RecyclerView: ${ProductosManager.productosEnContenedor.size}")


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
            // Redirige a la pantalla de "Modificar contenedor" (Pantalla 8)
            val intent = Intent(this, ModificarContenedorActivity::class.java)
            startActivity(intent)
        }
    }
}