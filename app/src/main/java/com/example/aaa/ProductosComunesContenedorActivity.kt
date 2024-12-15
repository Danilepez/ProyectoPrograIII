package com.example.aaa

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import com.example.aaa.adapters.Recycler.App.RecyclerProductosComunesContenedorAdapter
import com.example.aaa.databinding.ActivityProductosComunesContenedorBinding
import com.example.aaa.dataclasses.Producto
import com.example.aaa.singletons.ProductosComunes
import com.example.aaa.singletons.ProductosContenedor

class ProductosComunesContenedorActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProductosComunesContenedorBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductosComunesContenedorBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()

        binding.btnAgregar.setOnClickListener {
            ProductosComunes.productosComunesList.forEach { producto ->
                if (producto.cantidad > 0) {
                    val productoTemp = Producto(
                        nombre = producto.nombre,
                        fechaVencimiento = producto.fechaVencimiento,
                        estado = producto.estado,
                        lista = producto.lista,
                        cantidad = producto.cantidad,
                        imagen = producto.imagen
                    )

                    ProductosContenedor.productosContenedor.add(productoTemp)
                    producto.cantidad = 0
                }
            }

            Toast.makeText(this, "Productos agregados al contenedor y cantidades restablecidas.", Toast.LENGTH_SHORT).show()
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

