package com.example.aaa

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.aaa.adapters.Recycler.App.RecyclerProductosComunesContenedorAdapter
import com.example.aaa.databinding.ActivityProductosComunesContenedorBinding
import com.example.aaa.singletons.ProductosComunes
import com.example.aaa.singletons.ProductosContenedor

class ProductosComunesContenedorActivity : AppCompatActivity() {

    companion object {
        // Clave para pasar los productos seleccionados entre actividades
        const val CLAVE_PRODUCTOS_SELECCIONADOS = "PRODUCTOS_SELECCIONADOS"
    }

    private lateinit var binding: ActivityProductosComunesContenedorBinding
    private lateinit var adapter: RecyclerProductosComunesContenedorAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductosComunesContenedorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Configurar el RecyclerView
        adapter = RecyclerProductosComunesContenedorAdapter()
        binding.recyclerViewProductosComunes.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        binding.recyclerViewProductosComunes.adapter = adapter


        binding.btnAgregar.setOnClickListener {
            val productosSeleccionados = ProductosComunes.obtenerProductos().filter { it.cantidad > 0 }

            productosSeleccionados.forEach { productoSeleccionado ->
                val productoExistente = ProductosContenedor.obtenerProductos().find { it.nombre == productoSeleccionado.nombre }

                if (productoExistente != null) {
                    // Si ya existe, sumar la cantidad seleccionada
                    productoExistente.cantidad += productoSeleccionado.cantidad
                } else {
                    // Si no existe, agregar el producto con la cantidad seleccionada
                    ProductosContenedor.agregarProducto(productoSeleccionado.copy())
                }
            }

            // Pasar los productos seleccionados al ContenedorActivity
            val intent = Intent(this, ContenedorActivity::class.java)
            intent.putExtra(CLAVE_PRODUCTOS_SELECCIONADOS, ArrayList(productosSeleccionados)) // Enviar lista de productos
            startActivity(intent)

            // Reiniciar las cantidades en ProductosComunes
            ProductosComunes.obtenerProductos().forEach { it.cantidad = 0 }

            Toast.makeText(this, "Productos agregados al contenedor", Toast.LENGTH_SHORT).show()
        }
    }
}

