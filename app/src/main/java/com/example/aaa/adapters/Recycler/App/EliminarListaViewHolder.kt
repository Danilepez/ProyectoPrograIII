package com.example.aaa.adapters.Recycler.App

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.aaa.databinding.ItemListaEliminarBinding
import com.example.aaa.dataclasses.Lista

class EliminarListaViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemListaEliminarBinding.bind(view)

    fun render(lista: Lista, onSelectionChanged: (Lista, Boolean) -> Unit) {
        binding.tvNombreLista.text = lista.nombre


        binding.tvCantidadProductos.text = "${lista.listaProductos.size} productos"
        binding.cbLista.setOnCheckedChangeListener(null)
        binding.cbLista.isChecked = false

        binding.cbLista.setOnCheckedChangeListener { _, isChecked ->
            onSelectionChanged(lista, isChecked)
        }
    }
}