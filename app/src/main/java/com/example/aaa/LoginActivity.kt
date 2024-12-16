package com.example.aaa

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.aaa.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        auth = Firebase.auth

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (auth.currentUser != null) {
            val intentHomeScreen = Intent(this, PantallaPrincipalActivity::class.java)
            startActivity(intentHomeScreen)
            finish()
        }

        // Configurar el botón de inicio de sesión
        binding.btnLogin.setOnClickListener {
            val email = binding.etEmail.text.toString()
            val password = binding.etPassword.text.toString()

            loginUsuario(email, password)
        }
    }
    fun loginUsuario(email: String, password: String) {
        if (email.isEmpty()) {
            binding.etEmail.error = "Correo electrónico requerido"
            return
        }
        if (password.isEmpty()) {
            binding.passwdTitle.error = "Contraseña requerida"
            return
        }

        auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this) { respuesta ->
            if (respuesta.isSuccessful) {
                val user = auth.currentUser
                Toast.makeText(this, "Bienvenido, ${user?.email}", Toast.LENGTH_SHORT).show()

                val intentHomeScreen = Intent(this, PantallaPrincipalActivity::class.java)
                startActivity(intentHomeScreen)
                finish()
            } else {
                Toast.makeText(this, "Error en el inicio de sesión: ${respuesta.exception?.message}", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onStart() {
        super.onStart()

        val currentUser = auth.currentUser
        if (currentUser != null) {
            val intentHomeScreen = Intent(this, PantallaPrincipalActivity::class.java)
            startActivity(intentHomeScreen)
            finish()
        }
    }
}