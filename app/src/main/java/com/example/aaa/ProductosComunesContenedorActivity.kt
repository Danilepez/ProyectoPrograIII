package com.example.aaa

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.aaa.adapters.Recycler.App.RecyclerProductosComunesContenedorAdapter
import com.example.aaa.databinding.ActivityProductosComunesContenedorBinding
import com.example.aaa.dataclasses.Producto
import com.example.aaa.singletons.ProductosManager

class ProductosComunesContenedorActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProductosComunesContenedorBinding
    private lateinit var adapter: RecyclerProductosComunesContenedorAdapter

    // Lista temporal para almacenar los productos seleccionados con cantidad > 0
    private val productosSeleccionados = mutableListOf<Producto>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductosComunesContenedorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Configurar el RecyclerView
        adapter = RecyclerProductosComunesContenedorAdapter(productosSeleccionados)
        binding.recyclerViewProductosComunes.layoutManager = LinearLayoutManager(this)
        binding.recyclerViewProductosComunes.adapter = adapter

        // Cargar los productos comunes en el adaptador
        adapter.addDataToList(ProductosManager().productosComunes)

        // Acción del botón "Agregar"
        binding.btnAgregar.setOnClickListener {
            // Enviar los productos seleccionados al contenedor
            val intent = Intent(this, ContenedorActivity::class.java)
            intent.putExtra(ProductosManager.CLAVE_PRODUCTOS_SELECCIONADOS, ArrayList(productosSeleccionados))
            startActivity(intent)
            finish() // Cierra la actividad actual
        }
    }
}

