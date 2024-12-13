package com.example.aaa

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

        binding.btnLogin.setOnClickListener {
            loginUsuario()
        }
    }
    fun loginUsuario(){
        val email = binding.etEmail.text.toString()
        val password = binding.etPassword.text.toString()
        auth.signInWithEmailAndPassword(email,password).addOnCompleteListener(this){ respuesta ->
            if(respuesta.isSuccessful){
                Toast.makeText(this, "Iniciando sesión...", Toast.LENGTH_SHORT).show()
                //val intent = Intent(this, HomeActivity::class.java)
                //startActivity(intent)
                finish()
            } else{
                if (email.isEmpty()) binding.etEmail.error = "Correo electrónico requerido"
                if (password.isEmpty()) binding.etPassword.error = "Contraseña requerida"
                Toast.makeText(this, "Error en la autenticación", Toast.LENGTH_SHORT).show()
            }
        }
    }
}