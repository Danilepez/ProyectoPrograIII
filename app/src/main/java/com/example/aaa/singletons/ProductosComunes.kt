package com.example.aaa.singletons

import com.example.aaa.R
import com.example.aaa.dataclasses.Producto

object ProductosComunes {
    val productosComunesList = listOf<Producto>(
        Producto("Leche", "", "Bueno", "Lacteos", 0, R.drawable.pantalla_1),
        Producto("Pan", "", "Bueno", "Panaderia", 0, R.drawable.pantalla_1),
        Producto("Huevos", "", "Bueno", "Lacteos", 0, R.drawable.pantalla_1),
        Producto("Carne", "", "Bueno", "Carnes", 0, R.drawable.pantalla_1),
        Producto("Pescado", "", "Bueno", "Pescados", 0, R.drawable.pantalla_1),
        Producto("Pollo", "", "Bueno", "Carnes", 0, R.drawable.pantalla_1),
        Producto("Papas", "", "Bueno", "Verduras", 0, R.drawable.pantalla_1),
        Producto("Tomates", "", "Bueno", "Verduras", 0, R.drawable.pantalla_1)
    )
}



