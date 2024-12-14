package com.example.aaa.dataclasses

import java.io.Serializable

data class Producto(
    val nombre: String,
    val fechaVencimiento: String,
    val estado: String,
    val lista: String,
    val cantidad: Int
) : Serializable