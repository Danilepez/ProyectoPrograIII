package com.example.aaa.singletons

import com.example.aaa.R
import com.example.aaa.dataclasses.Lista
import com.example.aaa.dataclasses.Producto
import java.text.SimpleDateFormat
import java.util.*

object Listas {
    var listas = mutableListOf(
        Lista(
            id = 0,
            nombre = "Lista 1",
            listaProductos = mutableListOf(
                Producto(
                    nombre = "Leche",
                    fechaVencimiento = SimpleDateFormat("dd/MM/yyyy").parse("01/08/2024") ?: Date(),
                    estado = "Fresco",
                    lista = "Lácteos",
                    cantidad = 2,
                    imagen = R.drawable.carrito
                ),
                Producto(
                    nombre = "Pan",
                    fechaVencimiento = SimpleDateFormat("dd/MM/yyyy").parse("03/06/2024") ?: Date(),
                    estado = "Seco",
                    lista = "Panadería",
                    cantidad = 1,
                    imagen = R.drawable.carrito
                ),
                Producto(
                    nombre = "Manzanas",
                    fechaVencimiento = SimpleDateFormat("dd/MM/yyyy").parse("10/06/2024") ?: Date(),
                    estado = "Fresco",
                    lista = "Frutas",
                    cantidad = 5,
                    imagen = R.drawable.carrito
                )
            )
        ),
        Lista(
            id = 1,
            nombre = "Lista 2",
            listaProductos = mutableListOf(
                Producto(
                    nombre = "Arroz",
                    fechaVencimiento = SimpleDateFormat("dd/MM/yyyy").parse("20/12/2024") ?: Date(),
                    estado = "Seco",
                    lista = "Cereales",
                    cantidad = 3,
                    imagen = R.drawable.carrito
                )
            )
        ),
        Lista(
            id = 2,
            nombre = "Lista 3",
            listaProductos = mutableListOf()
        ),
        Lista(
            id = 3,
            nombre = "Lista 4",
            listaProductos = mutableListOf(
                Producto(
                    nombre = "Yogurt",
                    fechaVencimiento = SimpleDateFormat("dd/MM/yyyy").parse("15/06/2024") ?: Date(),
                    estado = "Fresco",
                    lista = "Lácteos",
                    cantidad = 6,
                    imagen = R.drawable.carrito
                )
            )
        ),
        Lista(
            id = 4,
            nombre = "Lista 5",
            listaProductos = mutableListOf(
                Producto(
                    nombre = "Pollo",
                    fechaVencimiento = SimpleDateFormat("dd/MM/yyyy").parse("08/06/2024") ?: Date(),
                    estado = "Congelado",
                    lista = "Carnes",
                    cantidad = 2,
                    imagen = R.drawable.carrito
                )
            )
        )
    )

    fun getListaByName(nombre: String): Lista? {
        return listas.find { it.nombre == nombre }
    }
}


