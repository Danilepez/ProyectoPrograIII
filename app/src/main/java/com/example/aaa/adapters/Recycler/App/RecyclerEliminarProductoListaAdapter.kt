package com.example.aaa.adapters.Recycler.App

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.aaa.R
import com.example.aaa.dataclasses.Producto

class RecyclerEliminarProductoListaAdapter(
    private val productos: List<Producto>,
    private val onSelectionChanged: (Producto, Boolean) -> Unit
) : RecyclerView.Adapter<EliminarProductoListaViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EliminarProductoListaViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return EliminarProductoListaViewHolder(
            layoutInflater.inflate(R.layout.item_eliminar_producto_lista, parent, false)
        )
    }

    override fun onBindViewHolder(holder: EliminarProductoListaViewHolder, position: Int) {
        val producto = productos[position]
        holder.render(producto, onSelectionChanged)
    }

    override fun getItemCount(): Int = productos.size
}
