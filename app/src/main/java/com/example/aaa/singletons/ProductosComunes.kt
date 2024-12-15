package com.example.aaa.singletons

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.aaa.R
import com.example.aaa.dataclasses.Producto

class ProductosComunes {

    companion object {
        val productosComunesList = listOf<Producto>(
            Producto("Leche", "2022-12-12", "Bueno", "Lacteos", 2, R.drawable.pantalla_1),
            Producto("Pan", "2022-12-12", "Bueno", "Panaderia", 2, R.drawable.pantalla_1),
            Producto("Huevos", "2022-12-12", "Bueno", "Lacteos", 2, R.drawable.pantalla_1),
            Producto("Carne", "2022-12-12", "Bueno", "Carnes", 2, R.drawable.pantalla_1),
            Producto("Pescado", "2022-12-12", "Bueno", "Pescados", 2, R.drawable.pantalla_1),
            Producto("Pollo", "2022-12-12", "Bueno", "Carnes", 2, R.drawable.pantalla_1),
            Producto("Papas", "2022-12-12", "Bueno", "Verduras", 2, R.drawable.pantalla_1),
            Producto("Tomates", "2022-12-12", "Bueno", "Verduras", 2, R.drawable.pantalla_1)
        )
    }
}


