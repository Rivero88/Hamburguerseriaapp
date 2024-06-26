package com.example.hamburguerseriaapp.Data

import com.example.hamburguerseriaapp.R

data class HamburgueseriaUIState(
    val pedidoActual: Pedido =
        Pedido(
            arrayListOf<Producto>(
                Producto(R.drawable.hamburguesa_simple,"Simple", 7, 0, arrayListOf(Ingrediente("Carne de ternera"), Ingrediente("queso"), Ingrediente("lechuga"), Ingrediente("tomate"), Ingrediente("pepinillo"), Ingrediente("ketchup"))),
                Producto(R.drawable.hamburguesa_doble,"Doble", 9,0, arrayListOf(Ingrediente("Doble de carne de ternera"), Ingrediente("queso"), Ingrediente("lechuga"), Ingrediente("tomate"), Ingrediente("pepinillo"), Ingrediente("ketchup"))),
                Producto(R.drawable.hamburguesa_pollo,"Pollo", 7, 0, arrayListOf(Ingrediente("Carne de pollo"), Ingrediente("queso"), Ingrediente("lechuga"), Ingrediente("tomate"), Ingrediente("mayonesa"))),
                Producto(R.drawable.hamburguesa_smash,"Smash", 10, 0,arrayListOf(Ingrediente("Carne de ternera smash"), Ingrediente("queso"), Ingrediente("lechuga"), Ingrediente("tomate"), Ingrediente("champiñones"), Ingrediente("bacon") , Ingrediente("BBQ"))),
                Producto(R.drawable.hamburguesa_mini,"Mini", 2, 0, arrayListOf(Ingrediente("Mini-carne de ternera"), Ingrediente("queso"), Ingrediente("lechuga"), Ingrediente("tomate"), Ingrediente("pepinillo"), Ingrediente("ketchup"))),
                Producto(R.drawable.hamburguesa_pescado,"Pescado", 9, 0, arrayListOf(Ingrediente("Filete pescado"), Ingrediente("lechuga"), Ingrediente("tomate"), Ingrediente("mayonesa")))
            ), 0
        ),
    var historicoPedidos: ArrayList<Pedido> = ArrayList()
)
