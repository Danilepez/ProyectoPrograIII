package com.example.aaa.adapters.Recycler.App

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.aaa.databinding.ItemCombinarBinding
import com.example.aaa.dataclasses.Producto

class CombinarViewHolder (view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemCombinarBinding.bind(view)

    fun render(producto: Producto, onSelectionChanged: (Producto, Boolean) -> Unit) {
        binding.tvNombre.text = producto.nombre

        // Limpiar el estado previo del CheckBox
        binding.cbProducto.setOnCheckedChangeListener(null)
        binding.cbProducto.isChecked = false

        binding.cbProducto.setOnCheckedChangeListener { _, isChecked ->
            onSelectionChanged(producto, isChecked)
        }
    }
}