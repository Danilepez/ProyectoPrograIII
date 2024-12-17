package com.example.aaa.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.aaa.databinding.ItemProductoBinding
import com.example.aaa.dataclasses.Producto

class RecyclerVencidosAdapter :
    RecyclerView.Adapter<RecyclerVencidosAdapter.ProductoViewHolder>() {

    private val listaDatos = mutableListOf<Producto>()
    private var context: Context? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductoViewHolder {
        context = parent.context
        val binding = ItemProductoBinding.inflate(LayoutInflater.from(context), parent, false)
        return ProductoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductoViewHolder, position: Int) {
        holder.bind(listaDatos[position])
    }

    override fun getItemCount(): Int = listaDatos.size

    inner class ProductoViewHolder(private val binding: ItemProductoBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(data: Producto) {
            // Solo asignamos el nombre y la fecha de vencimiento
            binding.tvNombre.text = data.nombre
            binding.tvFecha.text = data.fechaVencimiento
        }
    }

    fun addDataToList(list: List<Producto>) {
        listaDatos.clear()
        listaDatos.addAll(list)
        notifyDataSetChanged()
    }
}