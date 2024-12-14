package com.example.aaa

import android.content.Intent
import android.os.Bundle
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContenedorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvProducts.apply {
            layoutManager = LinearLayoutManager(this@ContenedorActivity)
            adapter = recyclerContenedorAdapter
        }

        // Recibir productos seleccionados desde la actividad de productos comunes
        val productosSeleccionados = intent.getSerializableExtra(ProductosManager.CLAVE_PRODUCTOS_SELECCIONADOS) as? ArrayList<Producto>
        if (productosSeleccionados != null) {
            ProductosManager().productosEnContenedor.addAll(productosSeleccionados)
        }

        // Cargar la lista del contenedor en el adaptador
        recyclerContenedorAdapter.addDataToList(ProductosManager().productosEnContenedor)


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