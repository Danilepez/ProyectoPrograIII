package com.example.aaa.adapters
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.aaa.databinding.ItemProductoBinding
import com.example.aaa.dataclasses.Producto

class RecyclerListaEjemploAdapter(private val productos: List<Producto>) : RecyclerView.Adapter<RecyclerListaEjemploAdapter.ProductoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductoViewHolder {
        val binding = ItemProductoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductoViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: ProductoViewHolder, position: Int) {
        holder.bind(productos[position])
    }

    override fun getItemCount() = productos.size

    class ProductoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ItemProductoBinding.bind(view)

        fun bind(producto: Producto) {
            binding.tvNombre.text = producto.nombre
            binding.tvLista.text = producto.lista
            binding.tvFecha.text = producto.fechaVencimiento
            binding.tvCantidad.text = "Cantidad: ${producto.cantidad}"
            binding.tvEstado.text = producto.estado
        }
    }
}
