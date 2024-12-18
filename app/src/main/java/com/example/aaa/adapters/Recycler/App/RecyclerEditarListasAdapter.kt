package com.example.aaa.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.aaa.R
import com.example.aaa.adapters.Recycler.App.EditarListasViewHolder
import com.example.aaa.dataclasses.Producto

class RecyclerEditarListasAdapter(private val productos: List<Producto>) : RecyclerView.Adapter<EditarListasViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EditarListasViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return EditarListasViewHolder(
            layoutInflater.inflate(R.layout.item_producto_editar_lista, parent, false)
        )
    }

    override fun onBindViewHolder(holder: EditarListasViewHolder, position: Int) {
        holder.render(productos[position])
    }

    override fun getItemCount(): Int = productos.size
}
