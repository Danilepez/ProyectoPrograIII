package com.example.aaa.adapters.Recycler.App

import android.content.Intent
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.aaa.ListaEjemploActivity
import com.example.aaa.databinding.ItemListaBinding
import com.example.aaa.dataclasses.Lista

class ListaViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    companion object {
        const val ID_LISTA = "ID_LISTA"
        const val NOMBRE_LISTA = "NOMBRE_LISTA"
    }
    val binding = ItemListaBinding.bind(view)

    fun render(listaModel: Lista) {
        binding.tvNombreLista.text = listaModel.nombre

        binding.tvCantidadProductos.text = "Cantidad: ${listaModel.listaProductos.size} productos"

        itemView.setOnClickListener {
            val intentD = Intent(itemView.context, ListaEjemploActivity::class.java)
            intentD.putExtra(ID_LISTA, listaModel.id)
            intentD.putExtra(NOMBRE_LISTA, listaModel.nombre)


            Toast.makeText(itemView.context, "Click en ${listaModel.nombre}", Toast.LENGTH_SHORT).show()
            itemView.context.startActivity(intentD)
        }
    }
}