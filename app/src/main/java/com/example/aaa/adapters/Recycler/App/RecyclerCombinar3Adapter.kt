package com.example.aaa.adapters.Recycler.App

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.aaa.R
import com.example.aaa.dataclasses.Producto

class RecyclerCombinar3Adapter(
    private val productos: List<Producto>,
    private val onSelectionChanged: (Producto, Boolean) -> Unit
) : RecyclerView.Adapter<Combinar3ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Combinar3ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_combinar3, parent, false)
        return Combinar3ViewHolder(view)
    }

    override fun onBindViewHolder(holder: Combinar3ViewHolder, position: Int) {
        val producto = productos[position]
        holder.render(producto, onSelectionChanged)
    }

    override fun getItemCount(): Int = productos.size
}

