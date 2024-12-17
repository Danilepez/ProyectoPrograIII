package com.example.aaa.adapters.Recycler.App

import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.aaa.databinding.ItemListaBinding
import com.example.aaa.dataclasses.Lista

class ListaViewHolder (view: View): RecyclerView.ViewHolder(view) {
    val binding = ItemListaBinding.bind(view)

    fun render(listaModel: Lista) {
        binding.tvNombreLista.text = listaModel.nombre
        binding.tvCantidadProductos.text = "Cantidad: ${listaModel.listaProductos.size} productos"

        binding.root.setOnClickListener {
            onListaClick(listaModel)
        }
    }
    private fun onListaClick(lista: Lista) {
        Toast.makeText(binding.tvNombreLista.context, "Lista seleccionada: ${lista.nombre}", Toast.LENGTH_SHORT).show()    }
}
