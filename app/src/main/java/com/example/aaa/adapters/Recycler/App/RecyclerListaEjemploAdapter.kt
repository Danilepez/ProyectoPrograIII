package com.example.aaa.adapters.Recycler.App

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.aaa.R
import com.example.aaa.dataclasses.Producto
import com.example.aaa.databinding.ItemProductoBinding
import com.example.aaa.dataclasses.ListaConProductos

class RecyclerListaEjemploAdapter(
    private val listaConProductos: List<ListaConProductos>,  // Ahora manejamos ListaConProductos
) : RecyclerView.Adapter<ListaViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListaViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ListaViewHolder(layoutInflater.inflate(R.layout.item_lista, parent, false))
    }

    override fun onBindViewHolder(holder: ListaViewHolder, position: Int) {
        // Pasamos la ListaConProductos al ViewHolder
        holder.render(listaConProductos[position])
    }

    override fun getItemCount(): Int = listaConProductos.size
}

