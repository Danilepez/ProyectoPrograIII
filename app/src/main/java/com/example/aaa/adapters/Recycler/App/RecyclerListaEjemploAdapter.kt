package com.example.aaa.adapters.Recycler.App

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.aaa.R
import com.example.aaa.dataclasses.Producto
import com.example.aaa.databinding.ItemProductoBinding

class ProductoAdapter :
    RecyclerView.Adapter<ProductoAdapter.ProductoViewHolder>() {

    private val listaDatos = mutableListOf<Producto>()
    private var context: Context? = null

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProductoViewHolder {
        context = parent.context
        return ProductoViewHolder(
            ItemProductoBinding.inflate(
                LayoutInflater.from(context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ProductoViewHolder, position: Int) {
        holder.bind(listaDatos[position])
    }

    override fun getItemCount(): Int = listaDatos.size

    inner class ProductoViewHolder(private val binding: ItemProductoBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(data: Producto) {
            binding.tvNombre.text = data.nombre
            binding.tvFecha.text = context?.getString(R.string.product_expiration_date, data.fechaVencimiento)
            binding.tvCantidad.text = context?.getString(R.string.product_quantity, data.cantidad)
            binding.tvEstado.text = context?.getString(R.string.product_status, data.estado)
            binding.tvLista.text = context?.getString(R.string.product_list, data.lista)
        }
    }

    fun setData(list: List<Producto>) {
        listaDatos.clear()
        listaDatos.addAll(list)
        notifyDataSetChanged()
    }
}
