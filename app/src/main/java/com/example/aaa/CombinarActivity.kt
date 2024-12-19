package com.example.aaa

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.aaa.adapters.Recycler.App.ListaViewHolder.Companion.ID_LISTA
import com.example.aaa.adapters.Recycler.App.ListaViewHolder.Companion.NOMBRE_LISTA
import com.example.aaa.adapters.Recycler.App.RecyclerCombinarAdapter
import com.example.aaa.databinding.ActivityCombinarBinding
import com.example.aaa.dataclasses.Producto
import com.example.aaa.singletons.ListaCombinada
import com.example.aaa.singletons.Listas

class CombinarActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCombinarBinding
    private lateinit var adapter: RecyclerCombinarAdapter
    private val productosSeleccionados = mutableListOf<Producto>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCombinarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtener los datos del Intent (NOMBRE_LISTA y ID_LISTA)
        val nombreLista = intent.getStringExtra(NOMBRE_LISTA)
        val idLista = intent.getIntExtra(ID_LISTA, 0)

        // Configurar el RecyclerView con los productos de la lista seleccionada
        initRecyclerView(idLista)

        // Configurar el título
        binding.titulo.text = nombreLista

        binding.btnSiguiente.setOnClickListener {
            if (productosSeleccionados.isNotEmpty()) {
                ListaCombinada.listaCombinada.addAll(productosSeleccionados)

                val intent = Intent(this, CombinarActivity2::class.java)
                intent.putExtra(NOMBRE_LISTA, nombreLista)
                intent.putExtra(ID_LISTA, idLista)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Selecciona al menos un producto", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun initRecyclerView(idLista: Int) {
        // Obtener los productos de la lista seleccionada usando el ID de la lista
        val productos = Listas.listas.getOrNull(idLista)?.listaProductos ?: emptyList()

        adapter = RecyclerCombinarAdapter(productos) { producto, isSelected ->
            if (isSelected) {
                productosSeleccionados.add(producto)
            } else {
                productosSeleccionados.remove(producto)
            }
        }

        binding.recyclerViewLists.adapter = adapter
        binding.recyclerViewLists.layoutManager = LinearLayoutManager(this)
    }
}

