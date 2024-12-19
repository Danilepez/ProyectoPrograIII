package com.example.aaa

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.aaa.adapters.Recycler.App.ListaViewHolder.Companion.ID_LISTA
import com.example.aaa.adapters.Recycler.App.ListaViewHolder.Companion.NOMBRE_LISTA
import com.example.aaa.adapters.Recycler.App.RecyclerCombinar3Adapter
import com.example.aaa.databinding.ActivityCombinar3Binding
import com.example.aaa.dataclasses.Lista
import com.example.aaa.dataclasses.Producto
import com.example.aaa.singletons.Listas
import com.example.aaa.singletons.ListasHelper

class CombinarActivity3 : AppCompatActivity() {

    private lateinit var binding: ActivityCombinar3Binding
    private lateinit var adapter: RecyclerCombinar3Adapter
    private val productosSeleccionados = mutableListOf<Producto>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCombinar3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val idLista = intent.getIntExtra(ID_LISTA, 0)  // Obtener el ID de la lista seleccionada
        val nombreLista = intent.getStringExtra(NOMBRE_LISTA)  // Obtener el nombre de la lista seleccionada

        val listaSeleccionada = Listas.listas.find { it.id == idLista }
        val productos = listaSeleccionada?.listaProductos ?: emptyList()

        initRecyclerView(productos)

        binding.titulo.text = nombreLista

        binding.btnCombinar.setOnClickListener {
            if (productosSeleccionados.isNotEmpty()) {
                mostrarDialogoNombreLista()
            } else {
                Toast.makeText(this, "Selecciona al menos un producto", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun initRecyclerView(productos: List<Producto>) {
        adapter = RecyclerCombinar3Adapter(productos) { producto, isSelected ->
            if (isSelected) {
                productosSeleccionados.add(producto)
            } else {
                productosSeleccionados.remove(producto)
            }
        }

        binding.recyclerViewLists.adapter = adapter
        binding.recyclerViewLists.layoutManager = LinearLayoutManager(this)
    }

    private fun mostrarDialogoNombreLista() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Ingrese el nombre de la nueva lista combinada")

        val input = EditText(this)
        input.inputType = InputType.TYPE_CLASS_TEXT
        builder.setView(input)

        builder.setPositiveButton("Aceptar") { _, _ ->
            val nombreNuevaLista = input.text.toString().trim()

            if (nombreNuevaLista.isNotEmpty()) {
                combinarProductos(nombreNuevaLista)
                val intent = Intent(this, ListasActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Debe ingresar un nombre válido", Toast.LENGTH_SHORT).show()
            }
        }

        builder.setNegativeButton("Cancelar") { dialog, _ ->
            dialog.cancel()
        }

        builder.show()
    }

    private fun combinarProductos(nombreLista: String) {
        val nuevaListaCombinada = Lista(
            id = Listas.listas.size + 1,
            nombre = nombreLista,
            listaProductos = mutableListOf()
        )

        for (producto in productosSeleccionados) {
            val existingProduct = nuevaListaCombinada.listaProductos.find { it.nombre == producto.nombre }
            if (existingProduct != null) {
                existingProduct.cantidad += producto.cantidad
            } else {
                nuevaListaCombinada.listaProductos.add(producto)
            }
        }

        ListasHelper.agregarLista(nombreLista, nuevaListaCombinada.listaProductos)

        Toast.makeText(this, "Productos combinados en la nueva lista: $nombreLista", Toast.LENGTH_SHORT).show()

        val intent = Intent(this, ListasActivity::class.java)
        startActivity(intent)
    }


}


