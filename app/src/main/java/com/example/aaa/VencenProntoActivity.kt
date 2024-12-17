package com.example.aaa

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.aaa.R
import com.example.aaa.adapters.RecyclerVencenProntoAdapter
import com.example.aaa.adapters.RecyclerVencidosAdapter
import com.example.aaa.dataclasses.Producto
import com.example.aaa.databinding.ActivityVencenProntoBinding

class VencenProntoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityVencenProntoBinding
    private lateinit var vencenProntoAdapter: RecyclerVencenProntoAdapter
    private lateinit var vencidosAdapter: RecyclerVencidosAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVencenProntoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        vencenProntoAdapter = RecyclerVencenProntoAdapter()
        binding.recyclerViewVencenPronto.layoutManager = LinearLayoutManager(this)
        binding.recyclerViewVencenPronto.adapter = vencenProntoAdapter

        vencidosAdapter = RecyclerVencidosAdapter()
        binding.recyclerViewVencidos.layoutManager = LinearLayoutManager(this)
        binding.recyclerViewVencidos.adapter = vencidosAdapter

        loadProductos()
    }

    private fun loadProductos() {
        val productosVencenPronto = listOf(
            Producto(id = 0, nombre = "Producto 1", fechaVencimiento = "12/12/2024", estado = "Vencido", lista = "Lista 1", cantidad = 5),
            Producto(id = 0, nombre = "Producto 2", fechaVencimiento = "15/01/2025", estado = "Vigente", lista = "Lista 2", cantidad = 3)
        )


        val productosVencidos = listOf(
            Producto(id = 0, nombre = "Producto 1", fechaVencimiento = "12/12/2024", estado = "Vencido", lista = "Lista 1", cantidad = 5),
            Producto(id = 0, nombre = "Producto 2", fechaVencimiento = "15/01/2025", estado = "Vigente", lista = "Lista 2", cantidad = 3)
        )


        vencenProntoAdapter.addDataToList(productosVencenPronto)
        vencidosAdapter.addDataToList(productosVencidos)
    }
}
