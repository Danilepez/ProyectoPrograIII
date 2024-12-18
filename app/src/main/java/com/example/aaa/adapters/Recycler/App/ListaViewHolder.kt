package com.example.aaa.adapters.Recycler.App

import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.aaa.databinding.ItemListaBinding
import com.example.aaa.dataclasses.Lista
import com.example.aaa.dataclasses.ListaConProductos
import com.example.aaa.room.DatabaseProvider

class ListaViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val binding = ItemListaBinding.bind(view)

    // DAO para acceder a la base de datos
    private val productoDao = DatabaseProvider.getDatabase(view.context).productoDao()

    fun render(listaConProductos: ListaConProductos) {
        // Accedemos a los datos de la lista
        val listaModel = listaConProductos.lista
        val productos = listaConProductos.productos

        // Configuramos el nombre y la cantidad de productos
        binding.tvNombreLista.text = listaModel.nombre
        binding.tvCantidadProductos.text = "Cantidad: ${productos.size} productos"  // Usamos 'productos' de ListaConProductos

        // Al hacer clic, podemos hacer algo con la lista (por ejemplo, ver los productos)
        binding.root.setOnClickListener {
            onListaClick(listaModel)
        }
    }

    private fun onListaClick(lista: Lista) {
        Toast.makeText(binding.tvNombreLista.context, "Lista seleccionada: ${lista.nombre}", Toast.LENGTH_SHORT).show()
    }
}
