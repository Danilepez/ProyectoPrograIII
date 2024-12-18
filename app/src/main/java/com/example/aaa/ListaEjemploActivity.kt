package com.example.aaa

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.aaa.databinding.ActivityListaEjemploBinding

class ListaEjemploActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListaEjemploBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListaEjemploBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}