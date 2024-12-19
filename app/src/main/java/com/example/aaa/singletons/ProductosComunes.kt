
package com.example.aaa.singletons

import com.example.aaa.R
import com.example.aaa.dataclasses.Producto
import java.util.*

object ProductosComunes {
    val productosComunesList = listOf<Producto>(
        Producto("Leche", Date(), "Bueno", "Lacteos", 0, R.drawable.carrito),
        Producto("Pan", Date(), "Bueno", "Panaderia", 0, R.drawable.carrito),
        Producto("Huevos", Date(), "Bueno", "Lacteos", 0, R.drawable.carrito),
        Producto("Carne", Date(), "Bueno", "Carnes", 0, R.drawable.carrito),
        Producto("Pescado", Date(), "Bueno", "Pescados", 0, R.drawable.carrito),
        Producto("Pollo", Date(), "Bueno", "Carnes", 0, R.drawable.carrito),
        Producto("Papas", Date(), "Bueno", "Verduras", 0, R.drawable.carrito),
        Producto("Tomates", Date(), "Bueno", "Verduras", 0, R.drawable.carrito)
    )
}