package com.example.aaa

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import com.example.aaa.adapters.Recycler.App.ListaViewHolder.Companion.ID_LISTA
import com.example.aaa.adapters.Recycler.App.ListaViewHolder.Companion.NOMBRE_LISTA
import com.example.aaa.adapters.Recycler.App.RecyclerAgregarProductoListaAdapter
import com.example.aaa.databinding.ActivityAgregarProductoListaBinding
import com.example.aaa.dataclasses.Producto
import com.example.aaa.singletons.Listas
import com.example.aaa.singletons.ProductosComunes

class AgregarProductoListaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAgregarProductoListaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAgregarProductoListaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initRecyclerView()

        binding.btnAgregar.setOnClickListener {
            val idLista = this.intent.getIntExtra(ID_LISTA, 0)
            val nombreLista = this.intent.getStringExtra(NOMBRE_LISTA)
            println(idLista)
            ProductosComunes.productosComunesList.forEach { producto ->
                if (producto.cantidad > 0) {
                    val existingProduct = Listas.getListaByName((Listas.listas[idLista].nombre))?.listaProductos?.find { it.nombre == producto.nombre }

                    if (existingProduct != null) {
                        existingProduct.cantidad += producto.cantidad
                    } else {
                        val productoTemp = Producto(
                            nombre = producto.nombre,
                            fechaVencimiento = producto.fechaVencimiento,
                            estado = producto.estado,
                            lista = producto.lista,
                            cantidad = producto.cantidad,
                            imagen = producto.imagen
                        )
                        Listas.listas[idLista].listaProductos.add(productoTemp)
                        Toast.makeText(this, "Productos agregados a la lista", Toast.LENGTH_SHORT).show()

                    }

                    producto.cantidad = 0
                }
            }



            val intentEditar = Intent(this, EditarListasActivity::class.java)
            intentEditar.putExtra(ID_LISTA, idLista)
            intentEditar.putExtra(NOMBRE_LISTA, nombreLista)
            startActivity(intentEditar)
        }
    }

    private fun initRecyclerView() {
        val manager = GridLayoutManager(this, 2)
        val decoration = DividerItemDecoration(this, manager.orientation)
        binding.recyclerViewAgregarProductosLista.layoutManager = manager
        binding.recyclerViewAgregarProductosLista.adapter = RecyclerAgregarProductoListaAdapter(ProductosComunes.productosComunesList)
        binding.recyclerViewAgregarProductosLista.addItemDecoration(decoration)
    }

}