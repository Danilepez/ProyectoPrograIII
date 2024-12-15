package com.example.aaa.adapters.Recycler.App

import android.app.DatePickerDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.aaa.R
import com.example.aaa.databinding.ItemProductoComunBinding
import com.example.aaa.dataclasses.Producto
import java.util.Calendar

class RecyclerProductosComunesContenedorAdapter(private val productosComunes: List<Producto>) : RecyclerView.Adapter<ProductosComunesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductosComunesViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ProductosComunesViewHolder(layoutInflater.inflate(R.layout.item_producto_comun, parent, false))
    }


    override fun onBindViewHolder(holder: ProductosComunesViewHolder, position: Int) {
        val item = productosComunes[position]
        holder.render(item)
    }

    override fun getItemCount(): Int = productosComunes.size

}

