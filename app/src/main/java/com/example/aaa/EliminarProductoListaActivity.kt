package com.example.aaa

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.aaa.adapters.Recycler.App.ListaViewHolder.Companion.ID_LISTA
import com.example.aaa.adapters.Recycler.App.ListaViewHolder.Companion.NOMBRE_LISTA
import com.example.aaa.adapters.Recycler.App.RecyclerEliminarProductoListaAdapter
import com.example.aaa.databinding.ActivityEliminarProductoListaBinding
import com.example.aaa.dataclasses.Producto
import com.example.aaa.singletons.Listas

class EliminarProductoListaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEliminarProductoListaBinding
    private val productosSeleccionados = mutableListOf<Producto>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEliminarProductoListaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val nombreLista = this.intent.getStringExtra(NOMBRE_LISTA)
        val idLista = this.intent.getIntExtra(ID_LISTA, 0)

        initRecyclerView(idLista)

        binding.tvTitulo.text = nombreLista.toString()

        binding.btnEliminar.isEnabled = false
        binding.btnEliminar.setOnClickListener {
            eliminarProductosSeleccionados(idLista)
            initRecyclerView(idLista)
        }
    }

    private fun initRecyclerView(idLista: Int) {
        val productos = Listas.listas[idLista].listaProductos

        binding.recyclerViewEliminarProductoLista.adapter = RecyclerEliminarProductoListaAdapter(productos) { producto, isChecked ->
            if (isChecked) {
                productosSeleccionados.add(producto)
            } else {
                productosSeleccionados.remove(producto)
            }

            binding.btnEliminar.isEnabled = productosSeleccionados.isNotEmpty()
        }

        val manager = LinearLayoutManager(this)
        binding.recyclerViewEliminarProductoLista.layoutManager = manager

    }

    private fun eliminarProductosSeleccionados(idLista: Int) {
        val nombreLista = this.intent.getStringExtra(NOMBRE_LISTA)

        if (productosSeleccionados.isNotEmpty()) {
            val productos = Listas.listas[idLista].listaProductos
            productos.removeAll { producto ->
                productosSeleccionados.contains(producto)
            }

            productosSeleccionados.clear()

            Toast.makeText(this, "Productos eliminados", Toast.LENGTH_SHORT).show()

            val intent = Intent(this, EditarListasActivity::class.java)
            intent.putExtra(ID_LISTA, idLista)
            intent.putExtra(NOMBRE_LISTA, nombreLista)
            startActivity(intent)
        } else {
            Toast.makeText(this, "No hay productos seleccionados", Toast.LENGTH_SHORT).show()
        }
    }
}