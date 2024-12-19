package com.example.aaa.adapters.Recycler.App

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.aaa.R
import com.example.aaa.dataclasses.Lista

class RecyclerCombinar2Adapter (
    private val listasParaCombinar: List<Lista>,
    private val onClick: (Int, String) -> Unit
) : RecyclerView.Adapter<Combinar2ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Combinar2ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_combinar2, parent, false)
        return Combinar2ViewHolder(view)
    }

    override fun onBindViewHolder(holder: Combinar2ViewHolder, position: Int) {
        val lista = listasParaCombinar[position]
        holder.render(lista, onClick)
    }

    override fun getItemCount(): Int = listasParaCombinar.size
}