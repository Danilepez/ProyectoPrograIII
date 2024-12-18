package com.example.aaa

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.aaa.R
import com.example.aaa.adapters.RecyclerListasAdapter
import com.example.aaa.singletons.Listas
import com.example.aaa.dataclasses.Lista

class ListasActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listas)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewLists)
        val adapter = RecyclerListasAdapter(Listas.listas) { lista ->
            val intent = Intent(this, EditarListasActivity::class.java)
            intent.putExtra("listaNombre", lista.nombre)
            startActivity(intent)
        }
        recyclerView.adapter = adapter
    }
}
