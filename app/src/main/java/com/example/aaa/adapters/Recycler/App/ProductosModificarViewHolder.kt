package com.example.aaa.adapters.Recycler.App

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.aaa.databinding.ItemProductoModificarBinding
import com.example.aaa.dataclasses.Producto
import java.text.SimpleDateFormat
import java.util.Locale

class ProductosModificarViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val binding = ItemProductoModificarBinding.bind(view)

    fun render(productoModel: Producto) {
        binding.tvNombre.text = productoModel.nombre
        binding.tvCantidad.text = "Cantidad: ${productoModel.cantidad}"

        // Convertir la fecha de vencimiento de Date a String
        val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
        val fechaString = dateFormat.format(productoModel.fechaVencimiento)
        binding.tvFecha.text = fechaString

        binding.tvEstado.text = productoModel.estado
    }
}
