package com.example.aaa.adapters.Recycler.App

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.aaa.R
import com.example.aaa.dataclasses.Producto

class RecyclerModificarContenedorAdapter(private val productos: List<Producto>) : RecyclerView.Adapter<ProductosModificarViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductosModificarViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ProductosModificarViewHolder(
            layoutInflater.inflate(R.layout.item_producto_modificar, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ProductosModificarViewHolder, position: Int) {
        holder.render(productos[position])
    }

    override fun getItemCount(): Int = productos.size
}