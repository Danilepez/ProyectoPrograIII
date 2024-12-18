package com.example.aaa

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.aaa.databinding.ActivityPantallaPrincipalBinding
import com.google.firebase.auth.FirebaseAuth
import com.example.aaa.ListasActivity
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class PantallaPrincipalActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPantallaPrincipalBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPantallaPrincipalBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = Firebase.auth

        binding.btnListas.setOnClickListener {
            val intent = Intent(this, ListasActivity::class.java)
            startActivity(intent)
        }

        binding.btnConte.setOnClickListener {
            val intent = Intent(this, ContenedorActivity::class.java)
            startActivity(intent)
        }

        binding.btnVence.setOnClickListener {
            val intent = Intent(this, VencenProntoActivity::class.java)
            startActivity(intent)
        }
        binding.btnCierre.setOnClickListener {
            cerrarSesion()
        }
    }
    fun cerrarSesion() {
        auth.signOut()

        val intent = Intent(this, LoginActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)

        finish()
    }
}