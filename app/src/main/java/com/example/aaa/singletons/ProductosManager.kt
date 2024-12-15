package com.example.aaa.singletons

import com.example.aaa.R
import com.example.aaa.dataclasses.Producto

class ProductosManager {

    // Lista de productos comunes (con cantidad = 0)
    companion object {
        val productosComunes = mutableListOf<Producto>(
            Producto("Producto 133", "2024-12-01", "Disponible", "Lista A", 0, R.drawable.pantalla_1),
            Producto("Producto 2", "2025-01-15", "Disponible", "Lista B", 0, R.drawable.pantalla_1),
            Producto("Producto 3", "2024-11-20", "Disponible", "Lista C", 0, R.drawable.pantalla_1),
            Producto("Producto 4", "2024-11-20", "Disponible", "Lista C", 0, R.drawable.pantalla_1),
            Producto("Producto 5", "2024-11-20", "Disponible", "Lista C", 0, R.drawable.pantalla_1),
            Producto("Producto 6", "2024-11-20", "Disponible", "Lista C", 0, R.drawable.pantalla_1)
        )

        // Lista de productos en el contenedor (cantidad > 0)
        val productosEnContenedor = mutableListOf<Producto>()

        // Claves para pasar datos entre actividades
        const val CLAVE_PRODUCTO_ID = "claveProductoId"
        const val CLAVE_PRODUCTO_NOMBRE = "claveProductoNombre"
        const val CLAVE_PRODUCTO_CANTIDAD = "claveProductoCantidad"
        const val CLAVE_PRODUCTOS_SELECCIONADOS = "claveProductosSeleccionados"
    }
}

