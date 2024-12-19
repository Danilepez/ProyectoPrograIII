package com.example.aaa.adapters.Recycler.App

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.aaa.databinding.ItemEliminarProductoListaBinding
import com.example.aaa.dataclasses.Producto

class EliminarProductoListaViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemEliminarProductoListaBinding.bind(view)

    fun render(productoModel: Producto, onSelectionChanged: (Producto, Boolean) -> Unit) {
        binding.tvNombre.text = productoModel.nombre
        binding.tvFecha.text = productoModel.fechaVencimiento
        binding.tvCantidad.text = productoModel.cantidad.toString()
        binding.tvLista.text = productoModel.lista
        binding.tvEstado.text = productoModel.estado

        binding.cbProducto.setOnCheckedChangeListener(null)
        binding.cbProducto.isChecked = false

        binding.cbProducto.setOnCheckedChangeListener { _, isChecked ->
            onSelectionChanged(productoModel, isChecked)
        }
    }
}