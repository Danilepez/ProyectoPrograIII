
package com.example.aaa.singletons

import com.example.aaa.R
import com.example.aaa.dataclasses.Producto
import java.util.*

object ProductosComunes {
    val productosComunesList = listOf<Producto>(
        Producto("Leche", Date(), "Bueno", "Lacteos", 0, R.drawable.pantalla_1),
        Producto("Pan", Date(), "Bueno", "Panaderia", 0, R.drawable.pantalla_1),
        Producto("Huevos", Date(), "Bueno", "Lacteos", 0, R.drawable.pantalla_1),
        Producto("Carne", Date(), "Bueno", "Carnes", 0, R.drawable.pantalla_1),
        Producto("Pescado", Date(), "Bueno", "Pescados", 0, R.drawable.pantalla_1),
        Producto("Pollo", Date(), "Bueno", "Carnes", 0, R.drawable.pantalla_1),
        Producto("Papas", Date(), "Bueno", "Verduras", 0, R.drawable.pantalla_1),
        Producto("Tomates", Date(), "Bueno", "Verduras", 0, R.drawable.pantalla_1)
    )
}