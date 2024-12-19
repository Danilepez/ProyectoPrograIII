package com.example.aaa.adapters.Recycler.App

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.aaa.databinding.ItemCombinar2Binding
import com.example.aaa.dataclasses.Lista

class Combinar2ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val binding = ItemCombinar2Binding.bind(view)

    fun render(lista: Lista, onClick: (Int, String) -> Unit) {
        binding.tvNombreLista.text = lista.nombre
        binding.tvCantidadProductos.text = "Cantidad de productos: ${lista.listaProductos.size}"
        itemView.setOnClickListener {
            onClick(lista.id, lista.nombre)
        }
    }
}