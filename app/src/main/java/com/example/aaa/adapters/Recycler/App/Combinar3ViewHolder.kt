package com.example.aaa.adapters.Recycler.App

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.aaa.databinding.ItemCombinar3Binding
import com.example.aaa.dataclasses.Producto

class Combinar3ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemCombinar3Binding.bind(view)

    fun render(producto: Producto, onSelectionChanged: (Producto, Boolean) -> Unit) {
        binding.tvNombre.text = producto.nombre

        binding.cbProducto.setOnCheckedChangeListener(null)
        binding.cbProducto.isChecked = false

        binding.cbProducto.setOnCheckedChangeListener { _, isChecked ->
            onSelectionChanged(producto, isChecked)
        }
    }
}
