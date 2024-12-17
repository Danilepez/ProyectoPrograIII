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

        binding.cbProducto.setOnCheckedChangeListener(null) // Evitar conflictos al reciclar vistas
        binding.cbProducto.isChecked = false // Inicialmente desmarcado

        binding.cbProducto.setOnCheckedChangeListener { _, isChecked ->
            // Informar a la actividad principal sobre la selección
            onSelectionChanged(productoModel, isChecked)
        }
    }
}