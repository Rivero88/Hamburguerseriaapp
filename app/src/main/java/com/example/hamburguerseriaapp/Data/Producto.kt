package com.example.hamburguerseriaapp.Data

import androidx.annotation.DrawableRes

data class Producto (
    @DrawableRes var imagen: Int,
    var nombre: String,
    var precio: Int,
    var cantidad: Int,
    var ingredientes: ArrayList<Ingrediente>
){
    /**
     * Esto es para que se muestren los ingredientes correctamente.
     * Es un override como los que se usan en java
     */
    override fun toString(): String {
        return nombre + "\n" + ingredientes.toString()
    }
}