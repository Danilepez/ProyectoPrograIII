package com.example.aaa.adapters.Recycler.App

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.aaa.R
import com.example.aaa.dataclasses.Producto

class RecyclerProductosComunesContenedorAdapter(private val productosComunes: List<Producto>) : RecyclerView.Adapter<ProductosComunesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductosComunesViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ProductosComunesViewHolder(layoutInflater.inflate(R.layout.item_producto_comun, parent, false))
    }


    override fun onBindViewHolder(holder: ProductosComunesViewHolder, position: Int) {
        val item = productosComunes[position]
        holder.render(item)

        holder.binding.btnSumar.setOnClickListener {
            holder.binding.tvCantidad.text = (holder.binding.tvCantidad.text.toString().toInt() + 1).toString()
            val cantidad = item.cantidad + 1
            item.cantidad = cantidad
        }

        holder.binding.btnRestar.setOnClickListener {
            if(holder.binding.tvCantidad.text.toString().toInt()>0) {
                holder.binding.tvCantidad.text = (holder.binding.tvCantidad.text.toString().toInt() - 1).toString()
            }
            if(item.cantidad > 0){
                val cantidad = item.cantidad - 1
                item.cantidad = cantidad
            }
        }

    }

    override fun getItemCount(): Int = productosComunes.size

}