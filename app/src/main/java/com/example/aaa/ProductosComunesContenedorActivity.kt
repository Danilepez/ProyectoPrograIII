package com.example.aaa

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import com.example.aaa.adapters.Recycler.App.RecyclerProductosComunesContenedorAdapter
import com.example.aaa.databinding.ActivityProductosComunesContenedorBinding
import com.example.aaa.dataclasses.Producto
import com.example.aaa.room.DatabaseProvider
import com.example.aaa.room.ProductoDao
import com.example.aaa.singletons.ProductosComunes
import com.example.aaa.singletons.ProductosContenedor
import kotlinx.coroutines.launch

class ProductosComunesContenedorActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProductosComunesContenedorBinding
    private lateinit var productoDao: ProductoDao // DAO para insertar y obtener productos

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductosComunesContenedorBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()

        // Inicializa la base de datos y el DAO
        val db = DatabaseProvider.getDatabase(applicationContext)
        productoDao = db.productoDao()


        binding.btnAgregar.setOnClickListener {
            ProductosComunes.productosComunesList.forEach { producto ->
                if (producto.cantidad > 0) {
                    val existingProduct = ProductosContenedor.productosContenedor.find {
                        it.nombre == producto.nombre && it.fechaVencimiento == producto.fechaVencimiento
                    }

                    if (existingProduct != null) {
                        existingProduct.cantidad += producto.cantidad
                    } else {
                        val productoTemp = Producto(
                            nombre = producto.nombre,
                            fechaVencimiento = producto.fechaVencimiento,
                            estado = producto.estado,
                            cantidad = producto.cantidad,
                            imagen = producto.imagen,
                            listaId = 0 // O asigna el ID de una lista, si es necesario
                        )
                        // Agregarlo al contenedor en memoria
                        ProductosContenedor.productosContenedor.add(productoTemp)
                    }

                    producto.cantidad = 0
                }
            }
            // Ahora guardar los productos en la base de datos usando lifecycleScope
            lifecycleScope.launch {
                // Aquí llamas al DAO para insertar los productos en la base de datos
                ProductosContenedor.productosContenedor.forEach { producto ->
                    if (producto.listaId == 0) { // Si el producto está en el contenedor temporal
                        // Guardar en la base de datos
                        db.productoDao().insertarProducto(producto) // Suponiendo que tienes un DAO y acceso a la base de datos
                    }
                }
            }

            Toast.makeText(this, "Productos agregados al contenedor", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, ContenedorActivity::class.java)
            startActivity(intent)
        }

    }

    private fun initRecyclerView() {
        val manager = GridLayoutManager(this, 2)
        val decoration = DividerItemDecoration(this, manager.orientation)
        binding.recyclerViewProductosComunes.layoutManager = manager
        binding.recyclerViewProductosComunes.adapter = RecyclerProductosComunesContenedorAdapter(ProductosComunes.productosComunesList)
        binding.recyclerViewProductosComunes.addItemDecoration(decoration)

    }
}

