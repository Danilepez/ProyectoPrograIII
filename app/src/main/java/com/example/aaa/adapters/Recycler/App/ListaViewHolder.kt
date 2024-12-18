package com.example.aaa.adapters.Recycler.App

import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.aaa.databinding.ItemListaBinding
import com.example.aaa.dataclasses.Lista

class ListaViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val binding = ItemListaBinding.bind(view)

    fun render(listaModel: Lista) {
        binding.tvNombreLista.text = listaModel.nombre

        binding.tvCantidadProductos.text = "Cantidad: ${listaModel.listaProductos.size} productos"

        binding.root.setOnClickListener {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                val productos = listaModel.listaProductos
                if (productos.isNotEmpty()) {
                    Toast.makeText(
                        binding.root.context,
                        "Posición clickeada: $position\nProductos: ${productos.joinToString { it.nombre }}",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    Toast.makeText(
                        binding.root.context,
                        "La lista seleccionada está vacía",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }
}