package com.example.aaa

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.StaggeredGridLayoutManager
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
        adapter = RecyclerProductosComunesContenedorAdapter()
        binding.recyclerViewProductosComunes.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        binding.recyclerViewProductosComunes.adapter = adapter

        // Cargar los productos comunes en el adaptador
        adapter.addDataToList(ProductosManager.productosComunes)

        // Acción del botón "Agregar"
        // Acción del botón "Agregar"
        binding.btnAgregar.setOnClickListener {
            // Filtrar productos seleccionados con cantidad > 0
            val productosSeleccionados = ProductosManager.productosComunes.filter { it.cantidad > 0 }.map { producto ->
                Producto(
                    nombre = producto.nombre,
                    fechaVencimiento = producto.fechaVencimiento,
                    estado = producto.estado,
                    lista = producto.lista,
                    cantidad = producto.cantidad,
                    imagen = producto.imagen
                )
            }

            // Crear un intent para pasar los productos seleccionados
            val intent = Intent(this, ContenedorActivity::class.java)
            intent.putExtra(ProductosManager.CLAVE_PRODUCTOS_SELECCIONADOS, ArrayList(productosSeleccionados)) // Pasar como ArrayList
            startActivity(intent)
            finish() // Cierra esta actividad
        }
    }

    // Método para reiniciar la cantidad de los productos a 0
    private fun resetCantidadDeProductos() {
        for (producto in ProductosManager.productosComunes) {
            producto.cantidad = 0
        }
    }
}

