package com.example.aaa.adapters.Recycler.App

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.aaa.databinding.ItemEliminarProductoContenedorBinding
import com.example.aaa.dataclasses.Producto

class EliminarContenedorViewHolder (view: View) : RecyclerView.ViewHolder(view) {
    val binding = ItemEliminarProductoContenedorBinding.bind(view)

    fun render(productoModel: Producto, onSelectionChanged: (Producto, Boolean) -> Unit) {
        binding.tvNombre.text = productoModel.nombre
        binding.tvFecha.text = productoModel.fechaVencimiento

        binding.cbProducto.setOnCheckedChangeListener(null)
        binding.cbProducto.isChecked = false //

        binding.cbProducto.setOnCheckedChangeListener { _, isChecked ->

            onSelectionChanged(productoModel, isChecked)
        }
    }
}