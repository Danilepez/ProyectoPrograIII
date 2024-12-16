package com.example.aaa.adapters.Recycler.App

import android.app.DatePickerDialog
import android.view.View
import android.widget.EditText
import androidx.recyclerview.widget.RecyclerView
import com.example.aaa.databinding.ItemProductoComunBinding
import com.example.aaa.dataclasses.Producto
import java.util.Calendar

class ProductosComunesViewHolder (view: View): RecyclerView.ViewHolder (view){

    val binding = ItemProductoComunBinding.bind(view)

    fun render(productoModel: Producto) {
        binding.tvNombreProductoComun.text = productoModel.nombre
        binding.tvCantidad.text = productoModel.cantidad.toString()
        binding.ivImagenProductoComun.setImageResource(productoModel.imagen)


        binding.etFecha.setText(productoModel.fechaVencimiento)
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
            val nuevaFecha = "$dayOfMonth/${monthOfYear + 1}/$year"
            productoModel.fechaVencimiento = nuevaFecha // Actualizamos el modelo
            etFecha.setText(nuevaFecha) // Reflejamos el cambio en la vista
        }, year, month, day)
        dpd.show()
    }
}