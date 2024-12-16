package com.example.aaa.adapters.Recycler.App

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.aaa.databinding.ItemProductoModificarBinding
import com.example.aaa.dataclasses.Producto

class ProductosModificarViewHolder(view: View): RecyclerView.ViewHolder (view){
    val binding = ItemProductoModificarBinding.bind(view)

    fun render(productoModel: Producto) {
        binding.tvNombre.text = productoModel.nombre
        binding.tvCantidad.text = "Cantidad: ${productoModel.cantidad}"
        binding.tvFecha.text = productoModel.fechaVencimiento
        binding.tvEstado.text = productoModel.estado
    }
}