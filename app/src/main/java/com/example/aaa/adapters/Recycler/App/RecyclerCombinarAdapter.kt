package com.example.aaa.adapters.Recycler.App

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.aaa.databinding.ItemCombinarBinding
import com.example.aaa.dataclasses.Producto

class RecyclerCombinarAdapter (
    private val productos: List<Producto>,
    private val onSelectionChanged: (Producto, Boolean) -> Unit
) : RecyclerView.Adapter<CombinarViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CombinarViewHolder {
        val binding = ItemCombinarBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CombinarViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: CombinarViewHolder, position: Int) {
        val producto = productos[position]
        holder.render(producto, onSelectionChanged)
    }

    override fun getItemCount(): Int = productos.size
}