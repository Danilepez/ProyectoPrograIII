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

        // Inicializar Firebase Auth
        auth = Firebase.auth

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Verificar si el usuario ya está autenticado
        if (auth.currentUser != null) {
            // Si el usuario está autenticado, redirigir a la pantalla principal
            val intentHomeScreen = Intent(this, PantallaPrincipalActivity::class.java)
            startActivity(intentHomeScreen)
            finish() // Finalizar LoginActivity para evitar que el usuario regrese
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

        // Intentar iniciar sesión con Firebase Auth
        auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this) { respuesta ->
            if (respuesta.isSuccessful) {
                val user = auth.currentUser
                Toast.makeText(this, "Bienvenido, ${user?.email}", Toast.LENGTH_SHORT).show()

                // Redirigir a la pantalla principal
                val intentHomeScreen = Intent(this, PantallaPrincipalActivity::class.java)
                startActivity(intentHomeScreen)
                finish() // Finalizar LoginActivity
            } else {
                // Mostrar error si no se puede iniciar sesión
                Toast.makeText(this, "Error en el inicio de sesión: ${respuesta.exception?.message}", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onStart() {
        super.onStart()

        // Verificar si hay un usuario autenticado
        val currentUser = auth.currentUser
        if (currentUser != null) {
            // Si ya hay un usuario autenticado, redirigir a la pantalla principal
            val intentHomeScreen = Intent(this, PantallaPrincipalActivity::class.java)
            startActivity(intentHomeScreen)
            finish() // Finalizar LoginActivity para que el usuario no regrese
        }
    }
}