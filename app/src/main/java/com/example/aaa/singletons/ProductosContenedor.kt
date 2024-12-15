package com.example.aaa.singletons

import com.example.aaa.dataclasses.Producto

class ProductosContenedor {
    companion object {
        private val productosContenedor = mutableListOf<Producto>()

        // Obtener todos los productos del contenedor
        fun obtenerProductos(): List<Producto> {
            return productosContenedor.toList() // Devolver una copia inmutable
        }

        // Agregar un nuevo producto al contenedor
        fun agregarProducto(producto: Producto) {
            productosContenedor.add(producto)
        }

        fun eliminarProducto(producto: Producto) {
            productosContenedor.remove(producto)
        }

        // Limpiar la lista de productos del contenedor
        fun limpiarProductos() {
            productosContenedor.clear()
        }
        fun actualizarProductos(nuevaLista: List<Producto>) {
            productosContenedor.clear()
            productosContenedor.addAll(nuevaLista)
        }

    }
}