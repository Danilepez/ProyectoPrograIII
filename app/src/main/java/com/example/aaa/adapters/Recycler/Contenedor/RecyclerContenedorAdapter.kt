package com.example.aaa.adapters.Recycler.Contenedor

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.aaa.dataclasses.Producto
import com.example.aaa.databinding.ItemProductoBinding

class RecyclerContenedorAdapter :
    RecyclerView.Adapter<RecyclerContenedorAdapter.ProductoViewHolder>() {

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
        holder.binding(listaDatos[position])
    }

    override fun getItemCount(): Int = listaDatos.size

    inner class ProductoViewHolder(private val binding: ItemProductoBinding) :
        RecyclerView.ViewHolder(binding.root)  {
        fun binding(data: Producto) {

            binding.tvProductName.text = data.nombre

        }
    }

    fun addDataToList(list: List<Producto>) {
        listaDatos.clear()
        listaDatos.addAll(list)
    }
}