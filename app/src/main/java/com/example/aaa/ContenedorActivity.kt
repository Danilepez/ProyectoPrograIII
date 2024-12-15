package com.example.aaa

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.aaa.adapters.Recycler.App.RecyclerContenedorAdapter
import com.example.aaa.databinding.ActivityContenedorBinding
import com.example.aaa.dataclasses.Producto
import com.example.aaa.singletons.ProductosContenedor

class ContenedorActivity : AppCompatActivity() {

    private lateinit var binding: ActivityContenedorBinding
    private val recyclerContenedorAdapter by lazy {RecyclerContenedorAdapter()}
    private var showDetails: Boolean = false // Estado global de visibilidad


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContenedorBinding.inflate(layoutInflater)
        setContentView(binding.root)


        // Obtener los productos seleccionados del Intent usando la clave
        val productosRecibidos = intent.getSerializableExtra(ProductosComunesContenedorActivity.CLAVE_PRODUCTOS_SELECCIONADOS) as? ArrayList<Producto>

        // Verificar si los productos existen y actualizar la UI
        productosRecibidos?.let {
            // Recorrer la lista de productos y agregar cada uno individualmente
            it.forEach { producto ->
                ProductosContenedor.agregarProducto(producto)
            }
        }

        binding.rvProducts.apply {
            layoutManager = LinearLayoutManager(this@ContenedorActivity)
            adapter = recyclerContenedorAdapter
        }

        //val productosRecibidos = intent.getSerializableExtra(ProductosComunes.CLAVE_PRODUCTOS_SELECCIONADOS) as? ArrayList<Producto>


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