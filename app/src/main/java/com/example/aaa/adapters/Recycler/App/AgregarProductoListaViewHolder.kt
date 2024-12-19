package com.example.aaa.adapters.Recycler.App

import android.app.DatePickerDialog
import android.view.View
import android.widget.EditText
import androidx.recyclerview.widget.RecyclerView
import com.example.aaa.databinding.ItemAgregarProductoListaBinding
import com.example.aaa.dataclasses.Producto
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

class AgregarProductoListaViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val binding = ItemAgregarProductoListaBinding.bind(view)

    fun render(productoModel: Producto) {
        binding.tvNombreProductoComun.text = productoModel.nombre
        binding.tvCantidad.text = productoModel.cantidad.toString()
        binding.ivImagenProductoComun.setImageResource(productoModel.imagen)

        // Convertir la fecha a String con formato adecuado
        val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
        val fechaString = dateFormat.format(productoModel.fechaVencimiento)
        binding.etFecha.setText(fechaString)

        binding.etFecha.setOnClickListener {
            showDatePickerDialog(binding.etFecha, productoModel)
        }
    }

    fun showDatePickerDialog(etFecha: EditText, productoModel: Producto) {
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        val dpd = DatePickerDialog(etFecha.context, { _, year, monthOfYear, dayOfMonth ->
            // Crear un nuevo objeto Date con la fecha seleccionada
            val nuevaFecha = Calendar.getInstance().apply {
                set(Calendar.YEAR, year)
                set(Calendar.MONTH, monthOfYear)
                set(Calendar.DAY_OF_MONTH, dayOfMonth)
            }.time

            productoModel.fechaVencimiento = nuevaFecha // Actualizamos el modelo con el nuevo Date
            // Convertir la nueva fecha a String para mostrarla en el EditText
            val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
            val fechaString = dateFormat.format(nuevaFecha)
            etFecha.setText(fechaString) // Reflejamos el cambio en la vista
        }, year, month, day)
        dpd.show()
    }
}
