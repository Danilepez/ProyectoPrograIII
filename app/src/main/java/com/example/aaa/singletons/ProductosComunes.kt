package com.example.aaa.singletons

import com.example.aaa.R
import com.example.aaa.dataclasses.Producto

class ProductosComunes {

    companion object {
        private val productosComunes = mutableListOf<Producto>()

        init {
            // Inicializar con algunos productos comunes por defecto
            productosComunes.addAll(
                listOf(
                    Producto("Producto 1", "2024-12-01", "Disponible", "Lista A", 0, R.drawable.pantalla_1),
                    Producto("Producto 2", "2025-01-15", "Disponible", "Lista B", 0, R.drawable.pantalla_1),
                    Producto("Producto 3", "2024-11-20", "Disponible", "Lista C", 0, R.drawable.pantalla_1),
                    Producto("Producto 4", "2024-12-01", "Disponible", "Lista A", 0, R.drawable.pantalla_1),
                    Producto("Producto 5", "2025-01-15", "Disponible", "Lista B", 0, R.drawable.pantalla_1),
                    Producto("Producto 6", "2024-11-20", "Disponible", "Lista C", 0, R.drawable.pantalla_1)
                )
            )
        }

        // Obtener todos los productos comunes
        fun obtenerProductos(): List<Producto> {
            return productosComunes.toList() // Devolver una copia inmutable
        }

        // Agregar un nuevo producto a la lista
        fun agregarProducto(producto: Producto) {
            productosComunes.add(producto)
        }

        // Limpiar la lista de productos comunes
        fun limpiarProductos() {
            productosComunes.clear()
        }
    }
}

