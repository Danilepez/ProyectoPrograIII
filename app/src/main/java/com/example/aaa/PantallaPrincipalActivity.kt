package com.example.aaa

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.aaa.databinding.ActivityPantallaPrincipalBinding
import com.google.firebase.auth.FirebaseAuth

class PantallaPrincipalActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPantallaPrincipalBinding
    private lateinit var auth: FirebaseAuth

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
        // Configura el botón de cerrar sesión
        binding.btnCierre.setOnClickListener {
            cerrarSesion()
        }
    }
    fun cerrarSesion() {
        auth.signOut() // Cierra la sesión del usuario actual

        // Redirige al usuario a la pantalla de inicio de sesión
        val intent = Intent(this, LoginActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)

        // Finaliza la actividad actual para evitar que el usuario vuelva atrás
        finish()
    }
}