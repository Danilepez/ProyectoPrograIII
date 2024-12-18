package com.example.aaa.adapters.Recycler.App

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.aaa.R
import com.example.aaa.dataclasses.Producto

class RecyclerAgregarProductoListaAdapter(private val productos: List<Producto>) : RecyclerView.Adapter<AgregarProductoListaViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AgregarProductoListaViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return AgregarProductoListaViewHolder(
            layoutInflater.inflate(R.layout.item_agregar_producto_lista, parent, false)
        )
    }

    override fun onBindViewHolder(holder: AgregarProductoListaViewHolder, position: Int) {
        val item = productos[position]
        holder.render(item)

        holder.binding.btnSumar.setOnClickListener {
            holder.binding.tvCantidad.text = (holder.binding.tvCantidad.text.toString().toInt() + 1).toString()
            val cantidad = item.cantidad + 1
            item.cantidad = cantidad
        }

        holder.binding.btnRestar.setOnClickListener {
            if(holder.binding.tvCantidad.text.toString().toInt() > 0) {
                holder.binding.tvCantidad.text = (holder.binding.tvCantidad.text.toString().toInt() - 1).toString()
            }
            if(item.cantidad > 0) {
                val cantidad = item.cantidad - 1
                item.cantidad = cantidad
            }
        }
    }

    override fun getItemCount(): Int = productos.size
}