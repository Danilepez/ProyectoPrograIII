package com.example.aaa.adapters.Recycler.App

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.aaa.databinding.ItemProductoEditarListaBinding
import com.example.aaa.dataclasses.Producto

class EditarListasViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val binding = ItemProductoEditarListaBinding.bind(view)

    fun render(productoModel: Producto) {
        binding.tvNombre.text = productoModel.nombre
        binding.tvCantidad.text = "Cantidad: ${productoModel.cantidad}"
        binding.tvFecha.text = productoModel.fechaVencimiento
        binding.tvEstado.text = productoModel.estado
        binding.tvLista.text = productoModel.lista
    }
}