package com.example.aaa.adapters.Recycler.App


import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.app.DatePickerDialog
import android.widget.ImageView
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.example.aaa.databinding.ItemProductoComunBinding
import com.example.aaa.dataclasses.Producto
import java.util.*
import java.text.SimpleDateFormat

class ProductosComunesViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val binding = ItemProductoComunBinding.bind(view)

    fun render(productoModel: Producto) {
        binding.tvNombreProductoComun.text = productoModel.nombre
        binding.tvCantidad.text = productoModel.cantidad.toString()
        binding.ivImagenProductoComun.setImageResource(productoModel.imagen)

        // Convertimos la fecha de vencimiento a un formato adecuado
        val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
        binding.etFecha.setText(sdf.format(productoModel.fechaVencimiento ?: Date())) // Asignamos la fecha en formato de texto
        binding.etFecha.setOnClickListener {
            showDatePickerDialog(binding.etFecha, productoModel)
        }
    }

    private fun showDatePickerDialog(etFecha: EditText, productoModel: Producto) {
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        val dpd = DatePickerDialog(etFecha.context, { _, year, monthOfYear, dayOfMonth ->
            val nuevaFecha = Calendar.getInstance()
            nuevaFecha.set(year, monthOfYear, dayOfMonth)

            // Actualizamos el modelo con la nueva fecha
            productoModel.fechaVencimiento = nuevaFecha.time

            // Actualizamos el EditText para mostrar la fecha seleccionada
            val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
            etFecha.setText(sdf.format(nuevaFecha.time)) // Mostramos la fecha en formato de texto
        }, year, month, day)
        dpd.show()
    }
}