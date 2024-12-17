package com.example.aaa

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.aaa.databinding.ActivityRegisterBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize Firebase Auth
        auth = Firebase.auth

        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnRegistrarse.setOnClickListener {
            val email = binding.correoed.text.toString()
            val password = binding.passwded.text.toString()
            val name = binding.nombreed.text.toString()  // Campo para el nombre del usuario
            registerUsuario(email, password, name)  // Pasar el nombre aquí
        }
    }
    fun registerUsuario(email: String, password: String, name: String){
        if (email.isEmpty()) {
            binding.tvEmail.error = "Correo electrónico requerido"
            return
        }
        if (password.isEmpty()) {
            binding.passwded.error = "Contraseña requerida"
            return
        }
        if (name.isEmpty()) {
            binding.nombreed.error = "Nombre requerido"
            return
        }

        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Registro exitoso
                    val user = auth.currentUser
                    user?.let {
                        // Guardamos el nombre en SharedPreferences
                        val sharedPreferences = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)
                        val editor = sharedPreferences.edit()
                        editor.putString("user_name", name)
                        editor.apply()
                    }

                    val intent = Intent(this, PantallaPrincipalActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    Toast.makeText(this, "Usuario registrado: ${user?.email}", Toast.LENGTH_SHORT).show()
                    startActivity(intent)
                } else {
                    // Error
                    Toast.makeText(this, "Error: ${task.exception?.message}", Toast.LENGTH_SHORT).show()
                }
            }
    }
}