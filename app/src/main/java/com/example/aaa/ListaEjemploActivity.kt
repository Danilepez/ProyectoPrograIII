package com.example.aaa

import android.content.Intent
import android.os.Bundle

import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.aaa.adapters.Recycler.App.ListaViewHolder.Companion.ID_LISTA
import com.example.aaa.adapters.Recycler.App.ListaViewHolder.Companion.NOMBRE_LISTA
import com.example.aaa.adapters.RecyclerListaEjemploAdapter
import com.example.aaa.databinding.ActivityListaEjemploBinding
import com.example.aaa.dataclasses.Producto
import com.example.aaa.singletons.Listas
import com.example.aaa.singletons.ProductosContenedor

class ListaEjemploActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListaEjemploBinding
    private val productosSeleccionados = mutableListOf<Producto>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListaEjemploBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val nombreLista = this.intent.getStringExtra(NOMBRE_LISTA)
        val idLista = this.intent.getIntExtra(ID_LISTA, 0)



        initRecyclerView(idLista)



        binding.titulo.text = nombreLista.toString()

        binding.btnModificar.setOnClickListener {
            val intentToEdit = Intent(this, EditarListasActivity::class.java)

            intentToEdit.putExtra(ID_LISTA, idLista)
            intentToEdit.putExtra(NOMBRE_LISTA, nombreLista)

            startActivity(intentToEdit)
            Toast.makeText(this, "Correcto", Toast.LENGTH_SHORT).show()


        }

        binding.btnCheck.setOnClickListener {
            eliminarSeleccionados(idLista)
        }

    }

    private fun initRecyclerView(idLista: Int) {
        val manager = LinearLayoutManager(this)
        val decoration = DividerItemDecoration(this, manager.orientation)

        binding.recyclerViewProductos.adapter = RecyclerListaEjemploAdapter(
            Listas.listas[idLista].listaProductos,
            { producto, isSelected ->
                onSelectionChanged(producto, isSelected)
            }
        )
        binding.recyclerViewProductos.layoutManager = manager
        binding.recyclerViewProductos.addItemDecoration(decoration)
    }
    private fun onSelectionChanged(producto: Producto, isSelected: Boolean) {
        val idLista = this.intent.getIntExtra(ID_LISTA, 0)
        val listaProductos = Listas.listas[idLista].listaProductos

        if (isSelected) {
            productosSeleccionados.add(producto)
        } else {
            productosSeleccionados.remove(producto)
        }
        if (binding.btnCheck.isSelected) {
            listaProductos.remove(producto)
        }
    }

    private fun eliminarSeleccionados(idLista: Int) {
        val listaProductos = Listas.listas[idLista].listaProductos

        ProductosContenedor.productosContenedor.addAll(productosSeleccionados)
        listaProductos.removeAll(productosSeleccionados)
        productosSeleccionados.clear()


        Toast.makeText(this, "Productos enviados al contenedor", Toast.LENGTH_SHORT).show()
    }
}