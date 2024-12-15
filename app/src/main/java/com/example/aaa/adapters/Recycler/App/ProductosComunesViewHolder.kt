package com.example.aaa.adapters.Recycler.App

import android.app.DatePickerDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.aaa.R
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
            showDatePickerDialog(binding.etFecha)
        }
    }
    fun showDatePickerDialog(etFecha: EditText) {
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        val dpd = DatePickerDialog(etFecha.context, { view, year, monthOfYear, dayOfMonth ->
            etFecha.setText("" + dayOfMonth + "/" + (monthOfYear + 1) + "/" + year)
        }, year, month, day)
        dpd.show()
    }
}