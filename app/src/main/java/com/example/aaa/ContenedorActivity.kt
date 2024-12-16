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
    private val recyclerContenedorAdapter by lazy { RecyclerContenedorAdapter() }
    private var showDetails: Boolean = false

    private val productosEnContenedor = mutableListOf<Producto>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContenedorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.d("ContenedorActivity", "Productos en contenedor: ${ProductosManager.productosEnContenedor.size}")

        binding.rvProducts.apply {
            layoutManager = LinearLayoutManager(this@ContenedorActivity)
            adapter = recyclerContenedorAdapter
        }

        // Recibir los productos enviados desde ListaEjemploActivity
        val productosRecibidos = intent.getSerializableExtra(ProductosManager.CLAVE_PRODUCTOS_SELECCIONADOS) as? ArrayList<Producto>

        productosRecibidos?.forEach { productoSeleccionado ->
            val productoExistente = productosEnContenedor.find { it.nombre == productoSeleccionado.nombre }

            if (productoExistente != null) {
                productoExistente.cantidad += productoSeleccionado.cantidad
            } else {
                productosEnContenedor.add(productoSeleccionado)
            }
        }

        recyclerContenedorAdapter.addDataToList(productosEnContenedor)
        Log.d("ContenedorActivity", "Productos enviados al RecyclerView: ${productosEnContenedor.size}")

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
}
