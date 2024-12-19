package com.example.aaa.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.aaa.databinding.ItemVencenProntoBinding
import com.example.aaa.dataclasses.Producto


class RecyclerVencenProntoAdapter : RecyclerView.Adapter<RecyclerVencenProntoAdapter.VencenProntoViewHolder>() {

    private var productos: List<Producto> = emptyList() // Lista de objetos Producto

    fun addDataToList(productos: List<Producto>) {
        this.productos = productos
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VencenProntoViewHolder {
        val binding = ItemVencenProntoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return VencenProntoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: VencenProntoViewHolder, position: Int) {
        val producto = productos[position]
        holder.bind(producto)
    }

    override fun getItemCount(): Int = productos.size

    class VencenProntoViewHolder(private val binding: ItemVencenProntoBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(producto: Producto) {
            binding.tvNombre.text = producto.nombre
            binding.tvFecha.text = producto.fechaVencimiento.toString()
        }
    }
}
