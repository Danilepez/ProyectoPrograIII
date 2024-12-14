package com.example.aaa.adapters.Recycler.App

import android.app.DatePickerDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.aaa.databinding.ItemProductoComunBinding
import com.example.aaa.dataclasses.Producto
import java.util.Calendar

class RecyclerProductosComunesContenedorAdapter(
    private val productosSeleccionados: MutableList<Producto> = mutableListOf()
) : RecyclerView.Adapter<RecyclerProductosComunesContenedorAdapter.ProductoViewHolder>() {

    private val listaDatos = mutableListOf<Producto>()
    private var context: Context? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductoViewHolder {
        context = parent.context
        val binding = ItemProductoComunBinding.inflate(LayoutInflater.from(context), parent, false)
        return ProductoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductoViewHolder, position: Int) {
        holder.bind(listaDatos[position])
    }

    override fun getItemCount(): Int = listaDatos.size

    inner class ProductoViewHolder(private val binding: ItemProductoComunBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(data: Producto) {
            binding.tvNombreProductoComun.text = data.nombre
            binding.ivImagenProductoComun.setImageResource(data.imagen)
            binding.tvCantidad.text = data.cantidad.toString()

            binding.btnSumar.setOnClickListener {
                binding.tvCantidad.text = binding.tvCantidad.text.toString().toInt().plus(1).toString()

                // Agregar a la lista temporal si la cantidad > 0
                if (!productosSeleccionados.contains(data)) {
                    productosSeleccionados.add(data)
                }
            }

            binding.btnRestar.setOnClickListener {
                if (binding.tvCantidad.text.toString().toInt() > 0) {
                    binding.tvCantidad.text = binding.tvCantidad.text.toString().toInt().minus(1).toString()

                    // Quitar de la lista temporal si la cantidad es 0
                    if (binding.tvCantidad.text.toString().toInt() == 0) {
                        productosSeleccionados.remove(data)
                    }
                }
            }
            binding.etFecha.setOnClickListener {
                showDatePickerDialog(data) // Mostrar el calendario al hacer clic en el campo de fecha
            }
        }
        private fun showDatePickerDialog(producto: Producto) {
            val calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)

            // Crear el DatePickerDialog
            val datePickerDialog = DatePickerDialog(
                context!!,
                { _, selectedYear, selectedMonth, selectedDay ->
                    // Establecer la fecha seleccionada en el EditText
                    val fechaSeleccionada = "$selectedDay/${selectedMonth + 1}/$selectedYear"
                    binding.etFecha.setText(fechaSeleccionada)

                    // Actualizar la fecha en el producto
                    producto.fechaVencimiento = fechaSeleccionada
                },
                year,
                month,
                day
            )

            // Mostrar el DatePickerDialog
            datePickerDialog.show()
        }
    }

    // Método para cargar datos en el adaptador
    fun addDataToList(list: List<Producto>) {
        listaDatos.clear()
        listaDatos.addAll(list)
        notifyDataSetChanged()
    }
}

