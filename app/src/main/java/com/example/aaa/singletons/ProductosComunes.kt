package com.example.aaa.singletons

import com.example.aaa.R
import com.example.aaa.dataclasses.Producto

object ProductosComunes {
    val productosComunesList = listOf<Producto>(
        Producto("Leche", "2022-12-12", "Bueno", "Lacteos", 0, R.drawable.pantalla_1),
        Producto("Pan", "2022-12-12", "Bueno", "Panaderia", 0, R.drawable.pantalla_1),
        Producto("Huevos", "2022-12-12", "Bueno", "Lacteos", 0, R.drawable.pantalla_1),
        Producto("Carne", "2022-12-12", "Bueno", "Carnes", 0, R.drawable.pantalla_1),
        Producto("Pescado", "2022-12-12", "Bueno", "Pescados", 0, R.drawable.pantalla_1),
        Producto("Pollo", "2022-12-12", "Bueno", "Carnes", 0, R.drawable.pantalla_1),
        Producto("Papas", "2022-12-12", "Bueno", "Verduras", 0, R.drawable.pantalla_1),
        Producto("Tomates", "2022-12-12", "Bueno", "Verduras", 0, R.drawable.pantalla_1)
    )
}



