package com.example.aaa

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.aaa.adapters.Recycler.App.ListaViewHolder.Companion.ID_LISTA
import com.example.aaa.adapters.Recycler.App.ListaViewHolder.Companion.NOMBRE_LISTA
import com.example.aaa.RecyclerListaEjemploAdapter
import com.example.aaa.databinding.ActivityListaEjemploBinding
import com.example.aaa.singletons.Listas

class ListaEjemploActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListaEjemploBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListaEjemploBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initRecyclerView()

        //cargarListaDesdeIntent()


        //binding.titulo.text = nameLista.toString()

        binding.btnModificar.setOnClickListener {
            val intentToEdit = Intent(this, EditarListasActivity::class.java)

            val nombreLista = this.intent.getStringExtra(NOMBRE_LISTA)
            val idLista = this.intent.getIntExtra(ID_LISTA, 0)
            intentToEdit.putExtra(ID_LISTA, idLista)
            intentToEdit.putExtra(NOMBRE_LISTA, nombreLista)


            startActivity(intentToEdit)
            Toast.makeText(this, "Correcto", Toast.LENGTH_SHORT).show()


        }
        binding.btnCheck.setOnClickListener {
        }
    }

    private fun initRecyclerView() {
        val manager = LinearLayoutManager(this)
        val decoration = DividerItemDecoration(this, manager.orientation)
        val idLista = this.intent.getIntExtra(ID_LISTA, 0)
        println(idLista)

        binding.recyclerViewProductos.layoutManager = manager
        binding.recyclerViewProductos.adapter = RecyclerListaEjemploAdapter(Listas.listas[idLista].listaProductos)
        binding.recyclerViewProductos.addItemDecoration(decoration)

    }

    /*private fun setupRecyclerView(productos: List<Producto>) {
        binding.recyclerViewProductos.adapter = RecyclerListaEjemploAdapter(productos)
    }*/

    /*private fun cargarListaDesdeIntent() {
        val listaNombre = this.intent.getStringExtra(NOMBRE_LISTA)  // Obtener el nombre de la lista desde el Intent
        val lista = Listas.getListaByName(listaNombre ?: "")// Buscar la lista en el Singleton

        if (lista != null) {
            if (lista.listaProductos.isNotEmpty()) {
                if (lista != null) {
                    setupRecyclerView(lista.listaProductos)
                }
            } else {
                Toast.makeText(this, "Lista no encontrada o está vacía", Toast.LENGTH_SHORT).show()
            }
        }
    }*/
}