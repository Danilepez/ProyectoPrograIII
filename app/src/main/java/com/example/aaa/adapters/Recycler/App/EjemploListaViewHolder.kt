package com.example.aaa.adapters.Recycler.App

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.aaa.databinding.ItemEjemploListaBinding
import com.example.aaa.dataclasses.Lista


class EjemploListaViewHolder(view : View) : RecyclerView.ViewHolder(view) {
    val binding = ItemEjemploListaBinding.bind(view)

    fun render(data: Lista) {
        binding.tvNombre.text = data.listaProductos[0].nombre
    }
}