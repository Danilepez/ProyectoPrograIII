package com.example.aaa.singletons

import com.example.aaa.R
import com.example.aaa.dataclasses.Lista
import com.example.aaa.dataclasses.Producto

object Listas {
    val listas = mutableListOf<Lista>(
        Lista(1, "Lista 1", mutableListOf<Producto>(Producto("Leche", "", "Bueno", "Lacteos", 0, R.drawable.pantalla_1))),
        Lista(2, "Lista 2", mutableListOf()),
        Lista(3, "Lista 3", mutableListOf()),
        Lista(4, "Lista 4", mutableListOf()),
        Lista(5, "Lista 5", mutableListOf())
    )
}