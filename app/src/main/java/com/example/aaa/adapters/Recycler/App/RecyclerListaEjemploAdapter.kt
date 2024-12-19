package com.example.aaa.adapters
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.aaa.adapters.Recycler.App.EjemploListaViewHolder
import com.example.aaa.databinding.ItemEjemploListaBinding
import com.example.aaa.dataclasses.Producto

class RecyclerListaEjemploAdapter(
    private val productos: List<Producto>,
    private val onSelectionChanged: (Producto, Boolean) -> Unit
) : RecyclerView.Adapter<EjemploListaViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EjemploListaViewHolder {
        val binding = ItemEjemploListaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return EjemploListaViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: EjemploListaViewHolder, position: Int) {
        holder.render(productos[position], onSelectionChanged)
    }

    override fun getItemCount() = productos.size
}
