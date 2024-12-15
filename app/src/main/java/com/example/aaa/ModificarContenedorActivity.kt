package com.example.aaa

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.aaa.adapters.Recycler.App.RecyclerModificarContenedorAdapter
import com.example.aaa.databinding.ActivityModificarContenedorBinding

class ModificarContenedorActivity : AppCompatActivity() {

    private lateinit var binding: ActivityModificarContenedorBinding
    private val recyclerModificarContenedorAdapter by lazy { RecyclerModificarContenedorAdapter() }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityModificarContenedorBinding.inflate(layoutInflater)
        setContentView(binding.root)


        // Configuración del RecyclerView
        binding.rvModificar.apply{
            layoutManager = LinearLayoutManager(this@ModificarContenedorActivity)
            adapter = recyclerModificarContenedorAdapter
        }

        // Configurar botón "+"
        binding.btnPlus.setOnClickListener {
            // Redirige a la pantalla de "Productos comunes contenedor" (Pantalla 9)
            val intent = Intent(this, ProductosComunesContenedorActivity::class.java)
            startActivity(intent)
        }

        // Configurar botón "-"
        binding.btnMinus.setOnClickListener {
            // Redirige a la pantalla de "Eliminar productos de contenedor" (Pantalla 10)
            val intent = Intent(this, EliminarProductosContenedorActivity::class.java)
            startActivity(intent)
        }
    }
}