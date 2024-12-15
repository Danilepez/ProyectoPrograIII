package com.example.aaa.adapters.Recycler.App

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.aaa.R
import com.example.aaa.dataclasses.Producto

class RecyclerContenedorAdapter(private val productos: List<Producto>) : RecyclerView.Adapter<ProductosViewHolder> (){

    private val listaDatos = mutableListOf<Producto>()
    private var context: Context? = null
    private var showDetails: Boolean = false // Controla la visibilidad de los detalles


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductosViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ProductosViewHolder(layoutInflater.inflate(R.layout.item_producto, parent, false))
    }

    override fun onBindViewHolder(holder: ProductosViewHolder, position: Int) {
        val item = productos[position]
        holder.render(item)
    }

    override fun getItemCount(): Int = productos.size



    // Actualiza el estado de visibilidad de los detalles y notifica el cambio
    /*fun toggleDetails(show: Boolean) {
        showDetails = show
        notifyDataSetChanged()
    }*/
}