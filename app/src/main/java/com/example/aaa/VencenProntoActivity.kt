package com.example.aaa

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.aaa.adapters.RecyclerVencenProntoAdapter
import com.example.aaa.adapters.RecyclerVencidosAdapter
import com.example.aaa.databinding.ActivityVencenProntoBinding
import com.example.aaa.singletons.ProductosContenedor
import java.util.*

class VencenProntoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityVencenProntoBinding
    private lateinit var vencenProntoAdapter: RecyclerVencenProntoAdapter
    private lateinit var vencidosAdapter: RecyclerVencidosAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVencenProntoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Llamar a la función para configurar los RecyclerView
        initRecyclerView()

        // Filtrar productos que vencen pronto
        val productosVencenPronto = ProductosContenedor.productosContenedor.filter {
            val expirationDate = it.fechaVencimiento  // Ya es un objeto Date?

            // Verificar si la fecha de vencimiento no es null y si está dentro del rango
            expirationDate?.let { fecha ->
                val currentDate = Date()
                fecha.after(currentDate) && fecha.before(Date(currentDate.time + 5 * 24 * 60 * 60 * 1000))
            } ?: false  // Si la fecha es null, excluir el producto
        }

        // Filtrar productos vencidos
        val productosVencidos = ProductosContenedor.productosContenedor.filter {
            val expirationDate = it.fechaVencimiento  // Ya es un objeto Date?

            // Verificar si la fecha de vencimiento no es null y si ha vencido
            expirationDate?.let { fecha ->
                val currentDate = Date()
                fecha.before(currentDate)
            } ?: false  // Si la fecha es null, excluir el producto
        }

        // Asignar los datos a los adaptadores
        if (productosVencenPronto.isNotEmpty()) {
            vencenProntoAdapter.addDataToList(productosVencenPronto)
        } else {
            Toast.makeText(this, "No hay productos que venzan pronto", Toast.LENGTH_SHORT).show()
        }

        if (productosVencidos.isNotEmpty()) {
            vencidosAdapter.addDataToList(productosVencidos)
        } else {
            Toast.makeText(this, "No hay productos vencidos", Toast.LENGTH_SHORT).show()
        }
    }

    private fun initRecyclerView() {
        // Crear un nuevo LinearLayoutManager para el RecyclerView "Vencen pronto"
        val managerVencenPronto = LinearLayoutManager(this)
        binding.recyclerViewVencenPronto.layoutManager = managerVencenPronto
        vencenProntoAdapter = RecyclerVencenProntoAdapter()
        binding.recyclerViewVencenPronto.adapter = vencenProntoAdapter

        // Crear un nuevo LinearLayoutManager para el RecyclerView "Vencidos"
        val managerVencidos = LinearLayoutManager(this)
        binding.recyclerViewVencidos.layoutManager = managerVencidos
        vencidosAdapter = RecyclerVencidosAdapter()
        binding.recyclerViewVencidos.adapter = vencidosAdapter
    }
}
