package com.example.aaa

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.aaa.adapters.Recycler.App.ListaViewHolder.Companion.ID_LISTA
import com.example.aaa.adapters.Recycler.App.ListaViewHolder.Companion.NOMBRE_LISTA
import com.example.aaa.adapters.RecyclerEditarListasAdapter
import com.example.aaa.databinding.ActivityEditarListasBinding
import com.example.aaa.singletons.Listas

class EditarListasActivity : AppCompatActivity() {


    private lateinit var binding: ActivityEditarListasBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditarListasBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val idLista = this.intent.getIntExtra(ID_LISTA, 0)
        val nombreLista = this.intent.getStringExtra(NOMBRE_LISTA)



        initRecyclerView(idLista)





        binding.btnPlus.setOnClickListener {
            val intentToEdit = Intent(this, AgregarProductoListaActivity::class.java)

            intentToEdit.putExtra(ID_LISTA, idLista)


            startActivity(intentToEdit)
        }

        binding.btnMinus.setOnClickListener {
            val intentToEdit = Intent(this, EliminarProductoListaActivity::class.java)

            intentToEdit.putExtra(ID_LISTA, idLista)
            intentToEdit.putExtra(NOMBRE_LISTA, nombreLista)

            startActivity(intentToEdit)
        }
    }

    private fun initRecyclerView(idLista: Int) {
        val manager = LinearLayoutManager(this)
        val decoration = DividerItemDecoration(this, manager.orientation)

        binding.rvModificar.layoutManager = manager
        binding.rvModificar.adapter = RecyclerEditarListasAdapter(Listas.listas[idLista].listaProductos)
        binding.rvModificar.addItemDecoration(decoration)

    }


}
