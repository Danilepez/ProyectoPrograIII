package com.example.aaa.adapters.Recycler.Contenedor

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.aaa.dataclasses.Producto
import com.example.aaa.databinding.ItemProductoBinding
import com.example.aaa.storage.SharedPreferencesUtil
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class RecyclerContenedorAdapter :
    RecyclerView.Adapter<RecyclerContenedorAdapter.ProductoViewHolder>() {

    private val listaDatos = mutableListOf<Producto>()
    private var context: Context? = null

    init{
        context?.let {
            listaDatos.addAll(SharedPreferencesUtil.loadFromSharedPreferences(it)) // Cargar lista de productos desde SharedPreferences
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProductoViewHolder {
        context = parent.context
        return ProductoViewHolder(
            ItemProductoBinding.inflate(
                LayoutInflater.from(context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ProductoViewHolder, position: Int) {
        holder.binding(listaDatos[position])
    }

    override fun getItemCount(): Int = listaDatos.size

    inner class ProductoViewHolder(private val binding: ItemProductoBinding) :
        RecyclerView.ViewHolder(binding.root)  {
        fun binding(data: Producto) {

            binding.tvProductName.text = data.nombre

        }
    }

    // Método para agregar datos a la lista y actualizar SharedPreferences
    fun addDataToList(list: List<Producto>) {
        listaDatos.clear()
        listaDatos.addAll(list)
        context?.let {
            SharedPreferencesUtil.saveToSharedPreferences(it, listaDatos)  // Guardar lista de productos en SharedPreferences
        }
        notifyDataSetChanged()  // Actualiza la vista para reflejar los nuevos datos
    }

    // Método para agregar un solo producto a la lista y guardar en SharedPreferences
    fun addProduct(product: Producto) {
        listaDatos.add(product)
        context?.let {
            SharedPreferencesUtil.saveToSharedPreferences(it, listaDatos)  // Guardar lista de productos en SharedPreferences
        }
        notifyDataSetChanged()
    }
}