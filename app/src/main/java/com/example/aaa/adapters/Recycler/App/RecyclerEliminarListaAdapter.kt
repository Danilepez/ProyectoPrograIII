package com.example.aaa.adapters.Recycler.App

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.aaa.databinding.ItemListaEliminarBinding
import com.example.aaa.dataclasses.Lista

class RecyclerEliminarListaAdapter(
    private val listas: List<Lista>,
    private val onSelectionChanged: (Lista, Boolean) -> Unit
) : RecyclerView.Adapter<EliminarListaViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EliminarListaViewHolder {
        val binding = ItemListaEliminarBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return EliminarListaViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: EliminarListaViewHolder, position: Int) {
        val lista = listas[position]
        holder.render(lista, onSelectionChanged)
    }

    override fun getItemCount(): Int = listas.size
}