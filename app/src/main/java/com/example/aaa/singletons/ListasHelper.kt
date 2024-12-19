package com.example.aaa.singletons

import com.example.aaa.adapters.RecyclerListasAdapter
import com.example.aaa.dataclasses.Lista
import com.example.aaa.dataclasses.Producto

object ListasHelper {
    lateinit var adapter: RecyclerListasAdapter

    fun agregarLista(nombreLista: String, productos: List<Producto> = emptyList()) {
        val ultimoId = Listas.listas.lastOrNull()?.id ?: 0
        val nuevoId = ultimoId + 1
        val nuevaLista = Lista(nuevoId, nombre = nombreLista, listaProductos = productos.toMutableList())
        Listas.listas.add(nuevaLista)
        adapter.notifyItemInserted(Listas.listas.size - 1)
    }
}
