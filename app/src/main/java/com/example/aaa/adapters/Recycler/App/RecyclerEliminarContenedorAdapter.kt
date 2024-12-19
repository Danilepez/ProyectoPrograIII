package com.example.aaa.adapters.Recycler.App

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.aaa.R
import com.example.aaa.dataclasses.Producto

class RecyclerEliminarContenedorAdapter(private val productos: List<Producto>,
                                        private val onSelectionChanged: (Producto, Boolean) -> Unit // Cambiamos la firma del callback
) : RecyclerView.Adapter<EliminarContenedorViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EliminarContenedorViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return EliminarContenedorViewHolder(layoutInflater.inflate(R.layout.item_eliminar_producto_contenedor, parent, false))
    }

    override fun onBindViewHolder(holder: EliminarContenedorViewHolder, position: Int) {
        val producto = productos[position]
        holder.render(producto, onSelectionChanged)
    }

    override fun getItemCount(): Int = productos.size
}


