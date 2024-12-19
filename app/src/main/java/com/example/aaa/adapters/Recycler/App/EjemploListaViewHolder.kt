package com.example.aaa.adapters.Recycler.App

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.aaa.databinding.ItemEjemploListaBinding
import com.example.aaa.dataclasses.Producto


class EjemploListaViewHolder(view : View) : RecyclerView.ViewHolder(view) {
    val binding = ItemEjemploListaBinding.bind(view)

    fun render(
        producto: Producto,
        onSelectionChanged: (Producto, Boolean) -> Unit
    ) {
        binding.tvNombre.text = producto.nombre
        binding.cbProducto.isChecked = false

        binding.cbProducto.setOnCheckedChangeListener { _, isChecked ->
            onSelectionChanged(producto, isChecked)
        }
    }
}