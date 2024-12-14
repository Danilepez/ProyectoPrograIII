package com.example.aaa.adapters.Recycler.App

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.aaa.R
import com.example.aaa.dataclasses.Producto
import com.example.aaa.databinding.ItemProductoBinding

class RecyclerContenedorAdapter :
    RecyclerView.Adapter<RecyclerContenedorAdapter.ProductoViewHolder>() {

    private val listaDatos = mutableListOf<Producto>()
    private var context: Context? = null
    private var showDetails: Boolean = false // Controla la visibilidad de los detalles

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
        holder.bind(listaDatos[position])
    }

    override fun getItemCount(): Int = listaDatos.size

    inner class ProductoViewHolder(private val binding: ItemProductoBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(data: Producto) {
            // Asignar el nombre del producto
            binding.tvNombre.text = data.nombre

            // Mostrar u ocultar los detalles según el estado de showDetails
            if (showDetails) {
                binding.tvLista.visibility = View.VISIBLE
                binding.tvFecha.visibility = View.VISIBLE
                binding.tvCantidad.visibility = View.VISIBLE
                binding.tvEstado.visibility = View.VISIBLE

                // Usar recursos de cadenas con marcadores de posición
                binding.tvLista.text =
                    context?.getString(R.string.product_list, data.lista)
                binding.tvFecha.text =
                    context?.getString(R.string.product_expiration_date, data.fechaVencimiento)
                binding.tvCantidad.text =
                    context?.getString(R.string.product_quantity, data.cantidad)
                binding.tvEstado.text =
                    context?.getString(R.string.product_status, data.estado)
            } else {
                binding.tvLista.visibility = View.GONE
                binding.tvFecha.visibility = View.GONE
                binding.tvCantidad.visibility = View.GONE
                binding.tvEstado.visibility = View.GONE
            }
        }
    }

    // Actualiza el estado de visibilidad de los detalles y notifica el cambio
    fun toggleDetails(show: Boolean) {
        showDetails = show
        notifyDataSetChanged()
    }

    // Agrega una lista de productos al adaptador
    fun addDataToList(list: List<Producto>) {
        listaDatos.clear()
        listaDatos.addAll(list)
        notifyDataSetChanged()
        //probar
    }
}