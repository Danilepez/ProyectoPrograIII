package com.example.aaa
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.aaa.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    // Declarar binding
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inicializar binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // Acción para el botón "Iniciar Sesión"
        binding.btnLogin.setOnClickListener {
            val intentLogin = Intent(this, MainActivity::class.java)
            startActivity(intentLogin)
        }

        // Acción para el botón "Registrarse"
        binding.btnRegister.setOnClickListener {
            val intentRegister = Intent(this, MainActivity::class.java)
            startActivity(intentRegister)
        }
    }
}