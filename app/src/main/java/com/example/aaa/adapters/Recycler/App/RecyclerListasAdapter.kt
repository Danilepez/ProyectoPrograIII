package com.example.aaa.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.aaa.R
import com.example.aaa.dataclasses.Lista
import com.example.aaa.adapters.Recycler.App.ListaViewHolder

class RecyclerListasAdapter(private val listas: List<Lista>) : RecyclerView.Adapter<ListaViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListaViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ListaViewHolder(layoutInflater.inflate(R.layout.item_lista, parent, false))
    }

    override fun onBindViewHolder(holder: ListaViewHolder, position: Int) {
        val lista = listas[position]
        holder.render(lista)
    }

    override fun getItemCount(): Int = listas.size
}