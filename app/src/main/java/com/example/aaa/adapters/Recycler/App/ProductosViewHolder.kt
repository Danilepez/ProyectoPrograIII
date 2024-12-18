package com.example.aaa.adapters.Recycler.App

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.aaa.R
import com.example.aaa.databinding.ItemProductoBinding
import com.example.aaa.dataclasses.Producto

class ProductosViewHolder (view: View): RecyclerView.ViewHolder(view) {

    val binding = ItemProductoBinding.bind(view)

    fun render(productoModel: Producto, showDetails: Boolean) {
        binding.tvNombre.text = productoModel.nombre

        // Mostrar u ocultar los detalles según el estado de showDetails
        if (showDetails) {
            binding.tvLista.visibility = View.VISIBLE
            binding.tvFecha.visibility = View.VISIBLE
            binding.tvCantidad.visibility = View.VISIBLE
            binding.tvEstado.visibility = View.VISIBLE

            // Usar recursos de cadenas con marcadores de posición
            binding.tvLista.text =
                binding.tvFecha.context?.getString(R.string.product_list, productoModel.lista)
            binding.tvFecha.text =
                binding.tvFecha.context?.getString(R.string.product_expiration_date, productoModel.fechaVencimiento)
            binding.tvCantidad.text =
                binding.tvFecha.context?.getString(R.string.product_quantity, productoModel.cantidad)
            binding.tvEstado.text =
                binding.tvFecha.context?.getString(R.string.product_status, productoModel.estado)
        } else {
            binding.tvLista.visibility = View.GONE
            binding.tvFecha.visibility = View.GONE
            binding.tvCantidad.visibility = View.GONE
            binding.tvEstado.visibility = View.GONE
        }
    }
}