package com.example.aaa.adapters.Recycler.App

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.aaa.databinding.ItemProductoModificarBinding
import com.example.aaa.dataclasses.Producto

class RecyclerModificarContenedorAdapter :
    RecyclerView.Adapter<RecyclerModificarContenedorAdapter.ProductoViewHolder>() {

    private val listaDatos = mutableListOf<Producto>()
    private var context: Context? = null

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProductoViewHolder {
        context = parent.context
        return ProductoViewHolder(
            ItemProductoModificarBinding.inflate(
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

    inner class ProductoViewHolder(private val binding: ItemProductoModificarBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(data: Producto) {
            binding.tvNombre.text = data.nombre
        }
    }

    fun addDataToList(list: List<Producto>) {
        listaDatos.clear()
        listaDatos.addAll(list)
        notifyDataSetChanged()
    }
}