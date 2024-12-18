package com.example.aaa.dataclasses

import java.io.Serializable


data class Lista(
    val id: Int,
    val nombre: String,
    val listaProductos: MutableList<Producto>
): Serializable