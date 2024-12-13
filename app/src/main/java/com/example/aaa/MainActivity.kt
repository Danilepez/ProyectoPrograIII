package com.example.aaa
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
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

        //Boton Iniciar Sesión
        binding.btnLogin.setOnClickListener {
            val intentLogin = Intent(this, ContenedorActivity::class.java)
            startActivity(intentLogin)
        }

        //Boton Registrarse
        binding.btnRegister.setOnClickListener {
            val intentRegister = Intent(this, RegisterActivity::class.java)
            startActivity(intentRegister)
        }
    }
}