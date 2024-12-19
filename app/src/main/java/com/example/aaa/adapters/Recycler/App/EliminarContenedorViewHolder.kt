package com.example.aaa.adapters.Recycler.App

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.aaa.databinding.ItemEliminarProductoContenedorBinding
import com.example.aaa.dataclasses.Producto
import java.text.SimpleDateFormat
import java.util.Locale

class EliminarContenedorViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val binding = ItemEliminarProductoContenedorBinding.bind(view)

    fun render(productoModel: Producto, onSelectionChanged: (Producto, Boolean) -> Unit) {
        binding.tvNombre.text = productoModel.nombre

        // Convertir la fecha de vencimiento a String con el formato adecuado
        val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
        val fechaString = dateFormat.format(productoModel.fechaVencimiento)
        binding.tvFecha.text = fechaString // Asignamos la fecha convertida a String

        binding.cbProducto.setOnCheckedChangeListener(null) // Evitar conflictos al reciclar vistas
        binding.cbProducto.isChecked = false // Inicialmente desmarcado

        binding.cbProducto.setOnCheckedChangeListener { _, isChecked ->
            onSelectionChanged(productoModel, isChecked)
        }
    }
}
