package com.example.aaa

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.aaa.databinding.ActivityPantallaPrincipalBinding

class PantallaPrincipalActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPantallaPrincipalBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPantallaPrincipalBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Configurar el clic del botón "Listas"
        binding.btnListas.setOnClickListener {
            val intent = Intent(this, ListasActivity::class.java)
            startActivity(intent)
        }

        // Configurar el clic del botón "Contenedor"
        binding.btnConte.setOnClickListener {
            val intent = Intent(this, ContenedorActivity::class.java)
            startActivity(intent)
        }

        // Configurar el clic del botón "Vencen Pronto"
        binding.btnVence.setOnClickListener {
            val intent = Intent(this, VencenProntoActivity::class.java)
            startActivity(intent)
        }
    }
}