package com.example.aaa.adapters.Recycler.App

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.aaa.R
import com.example.aaa.databinding.ItemEjemploListaBinding
import com.example.aaa.dataclasses.Producto
import com.example.aaa.databinding.ItemProductoBinding
import com.example.aaa.dataclasses.Lista
import com.example.aaa.singletons.Listas

class RecyclerListaEjemploAdapter(private val lista: Lista) : RecyclerView.Adapter<EjemploListaViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EjemploListaViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return EjemploListaViewHolder(layoutInflater.inflate(R.layout.item_ejemplo_lista, parent, false))
    }

    override fun onBindViewHolder(holder: EjemploListaViewHolder, position: Int) {
        holder.render(Listas.listas[position])
    }

    override fun getItemCount(): Int = Listas.listas.size

}
