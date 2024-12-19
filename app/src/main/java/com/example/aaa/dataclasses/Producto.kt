package com.example.aaa.dataclasses

import java.io.Serializable
import java.util.Date

data class Producto(
    val nombre: String,
    var fechaVencimiento: Date?,
    var estado: String,
    val lista: String,
    var cantidad: Int,
    val imagen: Int
) : Serializable