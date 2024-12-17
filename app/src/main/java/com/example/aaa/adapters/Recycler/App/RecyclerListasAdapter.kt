package com.example.aaa.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.aaa.R
import com.example.aaa.adapters.Recycler.App.ListaViewHolder
import com.example.aaa.dataclasses.Lista

class RecyclerListasAdapter(private val listas: List<Lista>, private val onItemClick: (Lista) -> Unit) : RecyclerView.Adapter<ListaViewHolder>() {

    // Crear el ViewHolder y asociarlo con el layout correspondiente
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListaViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ListaViewHolder(layoutInflater.inflate(R.layout.item_lista, parent, false))
    }

    // Asociar los datos a las vistas dentro del ViewHolder
    override fun onBindViewHolder(holder: ListaViewHolder, position: Int) {
        val lista = listas[position]
        holder.render(lista)
    }

    // Retornar el tamaño de la lista
    override fun getItemCount(): Int = listas.size
}
