package com.example.aaa.adapters.Recycler.App

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.aaa.databinding.ItemProductoEditarListaBinding
import com.example.aaa.dataclasses.Producto
import java.text.SimpleDateFormat
import java.util.Locale

class EditarListasViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val binding = ItemProductoEditarListaBinding.bind(view)

    fun render(productoModel: Producto) {
        binding.tvNombre.text = productoModel.nombre
        binding.tvCantidad.text = "Cantidad: ${productoModel.cantidad}"

        // Convertir la fecha de vencimiento a String con el formato adecuado
        val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
        val fechaString = dateFormat.format(productoModel.fechaVencimiento)
        binding.tvFecha.text = fechaString // Asignamos la fecha convertida a String

        binding.tvEstado.text = productoModel.estado
        binding.tvLista.text = productoModel.lista
    }
}
