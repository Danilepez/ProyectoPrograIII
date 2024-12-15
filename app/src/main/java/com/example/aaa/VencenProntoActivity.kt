package com.example.aaa.activities

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
            Producto("Producto 1", "12/12/2024", "Vencido", "Lista 1", 5),
            Producto("Producto 2", "15/01/2025", "Vigente", "Lista 2", 3)
        )

        val productosVencidos = listOf(
            Producto("Producto 3", "01/11/2024", "Vencido", "Lista 3", 8),
            Producto("Producto 4", "05/12/2024", "Vencido", "Lista 4", 2)
        )

        vencenProntoAdapter.addDataToList(productosVencenPronto)
        vencidosAdapter.addDataToList(productosVencidos)
    }
}
