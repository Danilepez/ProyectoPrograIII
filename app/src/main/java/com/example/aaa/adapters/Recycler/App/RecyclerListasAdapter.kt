package com.example.aaa.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.aaa.R
import com.example.aaa.dataclasses.Lista
import com.example.aaa.adapters.Recycler.App.ListaViewHolder

class RecyclerListasAdapter(
    private val listasParaCombinar: List<Lista>  // Nueva función para manejar el clic
) : RecyclerView.Adapter<ListaViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_lista, parent, false)
        return ListaViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListaViewHolder, position: Int) {
        val lista = listasParaCombinar[position]
        holder.render(lista)  // Pasamos la función de clic al ViewHolder
    }

    override fun getItemCount(): Int = listasParaCombinar.size
}
