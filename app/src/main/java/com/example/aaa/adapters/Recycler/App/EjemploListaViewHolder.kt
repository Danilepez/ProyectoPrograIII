package com.example.aaa.adapters.Recycler.App

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.aaa.databinding.ItemEjemploListaBinding
import com.example.aaa.dataclasses.Producto


class EjemploListaViewHolder(view : View) : RecyclerView.ViewHolder(view) {
    val binding = ItemEjemploListaBinding.bind(view)

    fun render(data: Producto) {
        binding.tvNombre.text = data.nombre
    }
}