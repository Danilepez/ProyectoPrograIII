package com.example.aaa.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.aaa.databinding.ItemListaBinding
import com.example.aaa.dataclasses.Lista

class RecyclerListasAdapter(
    private val listas: MutableList<Lista>,
    private val onItemClick: (Lista) -> Unit // Callback para manejar clics en las listas
) : RecyclerView.Adapter<RecyclerListasAdapter.ListaViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListaViewHolder {
        val binding = ItemListaBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ListaViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListaViewHolder, position: Int) {
        holder.bind(listas[position])
    }

    override fun getItemCount(): Int = listas.size

    inner class ListaViewHolder(private val binding: ItemListaBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(lista: Lista) {
            binding.tvNombreLista.text = lista.nombre
            binding.tvCantidadProductos.text = "${lista.cantidadProductos} productos"

            binding.root.setOnClickListener {
                onItemClick(lista)
            }
        }
    }

    fun updateList(newList: List<Lista>) {
        listas.clear()
        listas.addAll(newList)
        notifyDataSetChanged()
    }
}
