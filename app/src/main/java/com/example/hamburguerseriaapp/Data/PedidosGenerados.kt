package com.example.hamburguerseriaapp.Data

import com.example.hamburguerseriaapp.R

object DataSourcePedidos{
    var pedido1 = arrayListOf<Producto>(
        Producto(R.drawable.hamburguesa_simple,"Simple", 7, 3, arrayListOf(Ingrediente("Carne de ternera"), Ingrediente("queso"), Ingrediente("lechuga"), Ingrediente("tomate"), Ingrediente("pepinillo"), Ingrediente("ketchup"))),
        Producto(R.drawable.hamburguesa_doble,"Doble", 9, 4, arrayListOf(Ingrediente("Doble de carne de ternera"), Ingrediente("queso"), Ingrediente("lechuga"), Ingrediente("tomate"), Ingrediente("pepinillo"), Ingrediente("ketchup")))
    )

    var pedido2 = arrayListOf<Producto>(
        Producto(R.drawable.hamburguesa_mini,"Mini", 2, 3, arrayListOf(Ingrediente("Mini-carne de ternera"), Ingrediente("queso"), Ingrediente("lechuga"), Ingrediente("tomate"), Ingrediente("pepinillo"), Ingrediente("ketchup"))),
        Producto(R.drawable.hamburguesa_pescado,"Pescado", 9, 4, arrayListOf(Ingrediente("Filete pescado"), Ingrediente("lechuga"), Ingrediente("tomate"), Ingrediente("mayonesa")))
    )

    var pedidos = arrayListOf<Pedido>(Pedido(pedido1, 57),
        Pedido(pedido2, 44)
    )
}