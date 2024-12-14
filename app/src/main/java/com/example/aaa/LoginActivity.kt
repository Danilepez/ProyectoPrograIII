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

        // Initialize Firebase Auth
        auth = Firebase.auth

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)


        // Verificar si las credenciales están almacenadas
        val sharedPreferences = getSharedPreferences("USER_PREF", MODE_PRIVATE)
        val savedEmail = sharedPreferences.getString("EMAIL", null)
        val savedPassword = sharedPreferences.getString("PASSWORD", null)

        if (!savedEmail.isNullOrEmpty() && !savedPassword.isNullOrEmpty()) {
            // Si hay credenciales guardadas, iniciar sesión automáticamente
            loginUsuario(savedEmail, savedPassword, rememberMe = false)
        }

        binding.btnLogin.setOnClickListener {
            val email = binding.etEmail.text.toString()
            val password = binding.etPassword.text.toString()
            val rememberMe = binding.cbRememberMe.isChecked
            loginUsuario(email, password, rememberMe)
        }
    }
    fun loginUsuario(email: String, password: String, rememberMe: Boolean){
        if (email.isEmpty()) {
            binding.etEmail.error = "Correo electrónico requerido"
            return
        }
        if (password.isEmpty()) {
            binding.passwdTitle.error = "Contraseña requerida"
            return
        }
        auth.signInWithEmailAndPassword(email,password).addOnCompleteListener(this){ respuesta ->

            if(respuesta.isSuccessful){
                val user = auth.currentUser
                if(rememberMe){
                    val sharedPreferences = getSharedPreferences("USER_PREF", MODE_PRIVATE)
                    val editor = sharedPreferences.edit()
                    editor.putString("email", email)
                    editor.putString("password", password)
                    editor.apply()
                }

                Toast.makeText(this, "Inicio de sesión: ${user?.email}", Toast.LENGTH_SHORT).show()


                val intent = Intent(this, PantallaPrincipal::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(intent)
            } else{
                Toast.makeText(this, "Error en el inicio de sesión: ${respuesta.exception?.message}", Toast.LENGTH_SHORT).show()
            }
        }
    }
}