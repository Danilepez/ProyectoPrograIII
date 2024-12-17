package com.example.aaa.dataclasses

import java.io.Serializable

data class Producto(
    val nombre: String,
    var fechaVencimiento: String,
    var estado: String,
    val lista: String,
    var cantidad: Int,
    val imagen: Int
) : Serializable