package com.example.aaa.singletons

import com.example.aaa.R
import com.example.aaa.dataclasses.Lista
import com.example.aaa.dataclasses.Producto

object Listas {
    val listas = mutableListOf(
        Lista(
            nombre = "Lista 1",
            listaProductos = mutableListOf(
                Producto(
                    nombre = "Leche",
                    fechaVencimiento = "01/08/2024",
                    estado = "Fresco",
                    lista = "Lácteos",
                    cantidad = 2,
                    imagen = R.drawable.pantalla_1
                ),
                Producto(
                    nombre = "Pan",
                    fechaVencimiento = "03/06/2024",
                    estado = "Seco",
                    lista = "Panadería",
                    cantidad = 1,
                    imagen = R.drawable.pantalla_1
                ),
                Producto(
                    nombre = "Manzanas",
                    fechaVencimiento = "10/06/2024",
                    estado = "Fresco",
                    lista = "Frutas",
                    cantidad = 5,
                    imagen = R.drawable.pantalla_1
                )
            )
        ),
        Lista(
            nombre = "Lista 2",
            listaProductos = mutableListOf(
                Producto(
                    nombre = "Arroz",
                    fechaVencimiento = "20/12/2024",
                    estado = "Seco",
                    lista = "Cereales",
                    cantidad = 3,
                    imagen = R.drawable.pantalla_1
                )
            )
        ),
        Lista(
            nombre = "Lista 3",
            listaProductos = mutableListOf()
        ),
        Lista(
            nombre = "Lista 4",
            listaProductos = mutableListOf(
                Producto(
                    nombre = "Yogurt",
                    fechaVencimiento = "15/06/2024",
                    estado = "Fresco",
                    lista = "Lácteos",
                    cantidad = 6,
                    imagen = R.drawable.pantalla_1
                )
            )
        ),
        Lista(
            nombre = "Lista 5",
            listaProductos = mutableListOf(
                Producto(
                    nombre = "Pollo",
                    fechaVencimiento = "08/06/2024",
                    estado = "Congelado",
                    lista = "Carnes",
                    cantidad = 2,
                    imagen = R.drawable.pantalla_1
                )
            )
        )
    )

    fun getListaByName(nombre: String): Lista? {
        return listas.find { it.nombre == nombre }
    }
}

